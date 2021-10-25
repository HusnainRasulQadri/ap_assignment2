package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Filehandler {
	public static String[] getNthValue(String fileName,int nthValue,String value) {
		String line = "";
		String splitBy = ",";
		String[] ans = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] array = line.split(splitBy);
				if (array[nthValue].equals(value)) {
					ans = array;
				}
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ans;
	}
	public static String[][] getColumn(String fileName,int columnToBeMatched,String value,int ColumnToGet) {
		String line = "";
		String splitBy = ",";
		String ans[][] = new String[100][9];
		int j=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] array = line.split(splitBy);
				if (array[columnToBeMatched].equals(value)) {
					ans[j][0] = array[0];
					ans[j][1] = array[1];
					ans[j][2] = array[2];
					ans[j][3] = array[3];
					ans[j][4] = array[4];
					ans[j][5] = array[5];
					ans[j][6] = array[6];
					ans[j][7] = array[7];
					//ans[j][8] = array[8];
					j++;
				}
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ans;
	}
	public static String[][] getAllData(String fileName) {
		String line = "";
		String splitBy = ",";
		String ans[][] = new String[100][9];
		int j=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] array = line.split(splitBy);
					ans[j][0] = array[0];
					ans[j][1] = array[1];
					ans[j][2] = array[2];
					ans[j][3] = array[3];
					ans[j][4] = array[4];
					ans[j][5] = array[5];
					ans[j][6] = array[6];
					ans[j][7] = array[7];
					j++;
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ans;
	}
	public static void deleteData(String fileName,String toBeDeleted) {
		try {
            File inputFile = new File(fileName);
            if (!inputFile.isFile()) {
                System.out.println("File does not exist");
                return;
            }
            
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;

            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(toBeDeleted)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");
            }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
		catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
