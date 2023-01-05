package day03;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AppData {
    public static void main(String[] args) throws IOException {
        Path googlePath = Paths.get("googleplaystore.csv");
        File google = googlePath.toFile();
        String line;
        int noOfLines = 0;
        String[][] data = new String[11000][3]; //was noOfLines, which has value 0. Array size was hardcoded to size 0 from the start https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
        String[] dataoriginal;
        String[] categories = new String[noOfLines];
        List<String> categoriesList = new LinkedList<>();
        //String[] ratings = new String[noOfLines];
        int highestRating = 0;
        int lowestRating = 5;
        int average;
        int count = 0;
        int total = 0;

        if (!google.exists()) {
            System.err.println("File not found");
            System.exit(1);
        }

        FileReader fr = new FileReader(google);
        BufferedReader br = new BufferedReader(fr);
        /*while (null != (line = br.readLine())){
            noOfLines++;
        }

        for(int h = 0; h < noOfLines ; h++){
            br.mark(0);
            br.reset();
        }

        System.out.println("No of lines = "+ noOfLines);*/
        int i = -1;
        while (null != (line = br.readLine())) {
            i++;
            //for(int i = 0; i < 2 ; i++){
            line = line.trim();
            dataoriginal = line.split(",");
            for (int j = 0; j < 3; j++) {
                data[i][j] = dataoriginal[j];
            }
        }


            br.close();
            fr.close();

            for (int k = 0; k < data.length; k++) {
                System.out.println("{App name: " + data[k][0] + "} {Category: " + data[k][1] + "} {Rating: " + data[k][2] + "}");
            }

        /*for(int m = 0; m < noOfLines ; m++){
            categories[m] = data[1][m];
        }

        Arrays.sort(categories);

        categoriesList.add(categories[0]);

        for(int n = 0; n < categories.length ; n++){
            while(categories[n] != categories [n-1]){
                categoriesList.add(categories[n]);
            }
        }

        int noOfCat = categoriesList.size();

        for(int k = 0; k < noOfCat ; k++){
            for(int f = 1; f < noOfLines; f++){
                if(data[1][f] == categoriesList.get(k)){
                    if(data[2][f] != "NaN"){
                    count++;
                    total = total + Integer.parseInt(data[2][f]);

                    highestRating = Integer.parseInt(data[2][f]);
                    if(Integer.parseInt(data[2][f-1]) < Integer.parseInt(data[2][f])){
                        highestRating = Integer.parseInt(data[2][f]);
                    }

                    lowestRating = Integer.parseInt(data[2][f]);
                    if(Integer.parseInt(data[2][f-1]) > Integer.parseInt(data[2][f])){
                        lowestRating = Integer.parseInt(data[2][f]);
                    }
                
                }
                }
                average = total/count;
                System.out.println("Category: "+ categoriesList.get(k));
                System.out.println("Average: "+ average);
                System.out.println("Highest Rating: "+ highestRating);
                System.out.println("Lowest Rating: "+ lowestRating);
            }

        }*/

        }
}
