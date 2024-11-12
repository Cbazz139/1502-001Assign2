package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import model.Toy;
import view.Menu;

/**
 * the ToyStoreManager class manages the toy store inventory, it loads data,
 * search, add, remove, and save toys.
 * 
 * @author diltung
 */

public class ToyStoreManager {
	public ArrayList<Toy> listOfToys;
	Menu appMen;
	
	private final String FILE_PATH = "res/toys.txt";
	private Scanner input;
	
	/**
	 * Constructor for menu and toy list
	 */
	public ToyStoreManager() {
		appMen = new Menu();
		listOfToys = new ArrayList<>();
		input = new Scanner(System.in);
	}
	
	/**
	 * Loads the toy data from a file and adds the toys to the toy list.
	 */
	public void loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";"); 
				
				// Common attributes for all toys
				long serialNumber = Long.parseLong(parts[0]);
				String toyName = parts[1];
				String toyBrand = parts[2];
				double toyPrice = Double.parseDouble(parts[3]);
				int availableCount = Integer.parseInt(parts[4]);
				int appropriateAge = Integer.parseInt(parts[5]);

				Toy toy;
				long firstDigit = serialNumber / 1000000000; // Use the first digit to determine the toy type

				if (firstDigit == 0 || firstDigit == 1) {
					String classification = parts[6];
					toy = new Figure(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge,
							classification);
					
				} else if (firstDigit == 2 || firstDigit == 3) {
					String material = parts[6];
					String size = parts[7];
					toy = new Animal(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge,
							material, size);
					
				} else if (firstDigit >= 4 && firstDigit <= 6) {
					String puzzleType = parts[6];
					toy = new Puzzle(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge,
							puzzleType);
					
				} else if (firstDigit >= 7 && firstDigit <= 9) {
					String[] playerRange = parts[6].split("-");
					int minPlayer = Integer.parseInt(playerRange[0]);
					int maxPlayer = Integer.parseInt(playerRange[1]);
					String designers = parts[7];
					toy = new BoardGame(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge,
							maxPlayer, designers, minPlayer);
					
				} else {
					throw new IllegalArgumentException("Invalid toy type for serial number: " + serialNumber);
				}

				listOfToys.add(toy);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Error: Invalid number format in input file.");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * Launches the toy store application by displaying the main menu and handling
	 * user interactions.
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	public void launch() throws FileNotFoundException {
		boolean flag = true;
		int option;
		while (flag) {
			option = appMen.showmainmenu(listOfToys);
			switch (option) {
			case 1:
				// Search and purchase submenu
				int searchOption = appMen.searchAndPurchaseMenu();
				switch (searchOption) {
				case 1:
					// search by serial number
					long serialNumber = appMen.promptForLong("Enter the serial number of the toy to purchase: ", "\\d+",
							"Error: Invalid Serial Number. Please enter a non-negative integer.");
					purchaseToy(serialNumber);
					break;
				case 2:
					// Search by name
					String name = appMen.promptForString("Enter Toy Name: ");
					searchByName(name);
					break;
				case 3:
					// search by type
					String type = appMen.promptForString(
							"Enter the type of toy to search for (Figure, Animal, Puzzle, BoardGame): ");
					ArrayList<Toy> toysByType = byType(type);
					displayToys(toysByType);
					break;
				case 4:
					// Go back to the main menu
					appMen.showmainmenu(listOfToys);
					break;
				}
				break;
			case 2:
				// Add new toy
				Toy newToy = appMen.addnewtoy(listOfToys);
				listOfToys.add(newToy);
				break;
			case 3:
				// Remove a toy
				long removeSerialNumber = appMen.promptForLong("Enter Serial Number: ", "\\d+",
						"Error: Invalid Serial Number. Please enter a non-negative integer.");
				removeAToy(removeSerialNumber);
				break;
			case 4:
				// Save and exit the program
				save();
				flag = false;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}
	}

	/**
	 * Display list of toys
	 * 
	 * @param toys
	 */
	private void displayToys(ArrayList<Toy> toys) {
		if (toys.isEmpty()) {
			System.out.println("No toys found.");
		} else {
			for (Toy toy : toys) {
				System.out.println(toy);
			}
		}
	}
	
	/**
	 * Purchases a toy given a serial number. If the toy is available.
	 * 
	 * @param serialNumber
	 */
	private void purchaseToy(long serialNumber) {
		ArrayList<Toy> toys = getToyBySerialNumber(serialNumber);
		
		if (toys.isEmpty()) {
			System.out.println("No toy found with the given serial number.");
		} else {
			Toy toy = toys.get(0);
			if (toy.getAvailableCount() > 0) {
				toy.setAvailableCount(toy.getAvailableCount() - 1);
				System.out.println("Toy purchased successfully: " + toy.getName() + " by " + toy.getBrand());
			} else {
				System.out.println("Toy is out of stock.");
			}
		}
	}

	
	/**
	 * Returns a list of toys with the searched serial number.
	 * 
	 * @param serialNumber
	 * @return toys which user searched using serial number
	 */
	public ArrayList<Toy> getToyBySerialNumber(long serialNumber) {
		ArrayList<Toy> toys = new ArrayList<>();
		for (Toy t : listOfToys) {
			if (t.getSerialNumber() == serialNumber) {
				toys.add(t);
			}
		}
		return toys;
	}
	
	/**
	 * Returns a list of toys of a specific type.
	 * 
	 * @param type
	 * @return list of type of toys which user searched
	 */
	public ArrayList<Toy> byType(String type) {
		ArrayList<Toy> toys = new ArrayList<>();
		for (Toy t : listOfToys) {
			if (t.getClass().getSimpleName().equalsIgnoreCase(type)) {
				toys.add(t);
			}
		}

		if (!toys.isEmpty()) {
			System.out.println("Toys found with type '" + type + "':");
			for (Toy t : toys) {
				System.out.println("\t" + t.toString());
			}
		} else {
			System.out.println("No toys found with the type: " + type);
		}
		System.out.println("\nPress Enter to continue...");
		input.nextLine();

		return toys;
	}
	
	/**
	 * searches for toys by name and allows the user to purchase a toy from the
	 * results.
	 * 
	 * @param name
	 * @return ArrayList of Toy objects with names that contain the what user
	 *         searched
	 */
	public ArrayList<Toy> searchByName(String name) {
		ArrayList<Toy> toys = new ArrayList<>();
		for (Toy t : listOfToys) {
			if (t.getName().toLowerCase().contains(name.toLowerCase())) {
				toys.add(t);
			}
		}

		if (toys.isEmpty()) {
			System.out.println("No toys found with the given name.");
		} else {
			for (int i = 0; i < toys.size(); i++) {
				System.out.println("\t" + "(" + (i + 1) + ") " + toys.get(i));
			}
			System.out.println("\t" + "(" + (toys.size() + 1) + ") back to Search Menu");
			System.out.print("\nEnter option number to purchase: \n");
			int selected = appMen.input.nextInt();
			appMen.input.nextLine();

			if (selected >= 1 && selected <= toys.size()) {
				Toy toy = toys.get(selected - 1);
				if (toy.getAvailableCount() > 0) {
					toy.setAvailableCount(toy.getAvailableCount() - 1);
					System.out.println("You have successfully purchased: " + toy.getName());
				} else {
					System.out.println("Toy is out of stock.");
				}
			} else if (selected == toys.size() + 1) {

			} else {
				System.out.println("Invalid option. Returning to the submenu.");
			}
		}
		System.out.println("Press Enter to continue...");
		appMen.input.nextLine();
		appMen.searchAndPurchaseMenu();
		return toys;
	}

	/**
	 * Adds a new toy to the list of toys.
	 * 
	 */
	public void addNewToy() {
		appMen.addnewtoy(listOfToys);

	}
	
	/**
	 * Removes a toy from the list
	 * 
	 * @param serialNumber
	 * @return true if the toy was successfully removed, false otherwise
	 */
	public boolean removeAToy(long serialNumber) {
		for (Toy t : listOfToys) {
			if (t.getSerialNumber() == serialNumber) {
				System.out.println("This Item Found:\n" + "\n" + "\t" + t.toString());
				System.out.println("\nDo you want to remove it? (Y/N)");
				String userInput = input.nextLine().trim().toUpperCase();

				if (userInput.equals("Y")) {
					listOfToys.remove(t);
					System.out.println("\nItem Removed!");
					System.out.println("\nPress Enter to continue...");
					input.nextLine();
					return true;
				} else {
					System.out.println("Toy removal canceled.");
					return false;
				}
			}
		}
		System.out.println("No toy found with the serial number: " + serialNumber);
		return false;
	}
	
	/**
	 * Saves the list of toys to a file.
	 */
	public void save() {
		File info = new File(FILE_PATH);
		try {
			PrintWriter pw = new PrintWriter(info);
			for (Toy t : listOfToys) {
				String toyInfo = String.format("%d;%s;%s;%.2f;%d;%d;", t.getSerialNumber(), t.getName(), t.getBrand(),
						t.getPrice(), t.getAvailableCount(), t.getAgeAppropriate());

				if (t instanceof Figure) {
					Figure f = (Figure) t;
					toyInfo += f.getClassification();
				} else if (t instanceof Animal) {
					Animal a = (Animal) t;
					toyInfo += a.getMaterial() + ";" + a.getSize();
				} else if (t instanceof Puzzle) {
					Puzzle p = (Puzzle) t;
					toyInfo += p.getPuzzleType();
				} else if (t instanceof BoardGame) {
					BoardGame b = (BoardGame) t;
					toyInfo += String.format("%d-%d;%s", b.getMinPlayer(), b.getMaxPlayers(), b.getDesigners());
				}

				pw.println(toyInfo);
			}
			pw.close();
			System.out.println("Saving Data into database");
		} catch (FileNotFoundException e) {
			System.out.println("Error: Unable to save data to the file.");
			e.printStackTrace();
		}
	}

}

