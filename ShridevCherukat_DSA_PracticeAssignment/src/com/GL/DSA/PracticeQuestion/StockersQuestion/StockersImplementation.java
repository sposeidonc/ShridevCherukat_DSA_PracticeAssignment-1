package com.GL.DSA.PracticeQuestion.StockersQuestion;

import java.util.Scanner;

public class StockersImplementation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of Companies: ");
		int companySize = input.nextInt();
		double[] companies = new double[companySize];
		boolean[] companyStock = new boolean[companySize];
		for (int i = 0; i < companySize; i++) {
			System.out.println("---------------------------------");
			System.out.println("Enter the stock price of Company " + (i + 1) + " : ");
			companies[i] = input.nextDouble();
			System.out.println(
					"Whether the company's stock price rose today compared to yesterday? (true or false only)");
			companyStock[i] = input.nextBoolean();
		}
		StockersImplementation obj = new StockersImplementation();
		obj.PerformOperations(companies, companyStock, companySize);
		input.close();
	}

	private void PerformOperations(double[] companies, boolean[] companyStock, int companySize) {
		boolean onceMore = true;
		while (onceMore) {
			System.out.println("---------------------------------");
			System.out.println("Enter the operation that you want to perform:\r\n"
					+ "1. Display the companies stock prices in ascending order\r\n"
					+ "2. Display the companies stock prices in descending order\r\n"
					+ "3. Display the total no of companies for which stock prices rose today\r\n"
					+ "4. Display the total no of companies for which stock prices declined today\r\n"
					+ "5. Search a specific stock price\r\n" + "Press 0 to exit\r\n"
					+ "---------------------------------");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			switch (option) {
			case 1:
				performMergeSort(companies, 0, companySize - 1);
				displayArrayForAscOrDesc(companies, companySize, 0);
				break;
			case 2:
				performMergeSort(companies, 0, companySize - 1);
				displayArrayForAscOrDesc(companies, companySize, 1);
				break;
			case 3:
				int counter = 0;
				for (int i = 0; i < companySize; i++) {
					if (companyStock[i] == true) {
						counter++;
					}
				}
				System.out.println("Total number of companies whose stock price rose today : " + counter);
				break;
			case 4:
				int counter2 = 0;
				for (int i = 0; i < companySize; i++) {
					if (companyStock[i] == false) {
						counter2++;
					}
				}
				System.out.println("Total number of companies whose stock price declined today :" + counter2);
				break;
			case 5:
				System.out.println("Enter the Stock to search for: ");
				double stock = input.nextDouble();
				searchStock(companies, 0, companySize - 1, stock);
				break;
			case 0:
				onceMore = false;
				System.out.println("Exited Succesfully!");
				break;
			default:
				System.out.println("Please enter a valid response!!!!");
			}
			input.close();
		}
		
	}

	private void searchStock(double[] arr, int left, int right, double stock) {
		int mid = (left + right) / 2;
		while (left <= right) {
			if (arr[mid] < stock) {
				left = mid + 1;
			} else if (arr[mid] == stock) {
				System.out.println("Stock of value " + arr[mid] + " is present!");
				return;
			} else if (arr[mid] > stock) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		System.out.println("Given stock value not present!!!!");
	}

	private void performMergeSort(double[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			performMergeSort(arr, left, mid);
			performMergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}

	}

	private void merge(double[] arr, int left, int mid, int right) {
		int len1 = (int) (mid - left + 1);
		int len2 = (int) (right - mid);

		double[] leftArr = new double[len1];
		double[] rightArr = new double[len2];

		for (int i = 0; i < len1; i++) {
			leftArr[i] = arr[(int) (left + i)];
		}
		for (int j = 0; j < len2; j++) {
			rightArr[j] = arr[(int) (mid + 1 + j)];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = (int) left;
		while (i < len1 && j < len2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	private void displayArrayForAscOrDesc(double[] arr, int size, int order) {
		if (order == 0) {
			for (int i = 0; i < size; i++) {
				if (i == size - 1) {
					System.out.println(arr[i]);
				} else {
					System.out.print(arr[i] + " < ");
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (i == 0) {
					System.out.println(arr[i]);
				} else {
					System.out.print(arr[i] + " > ");
				}
			}
		}
		System.out.println();
	}
}
