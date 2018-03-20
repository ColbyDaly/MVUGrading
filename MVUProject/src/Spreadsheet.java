import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Spreadsheet {

	public static void main(String[] args) {
		
		String csvFile = "spreadsheet.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        //ArrayList<Foo> list = new ArrayList<Foo>();
        
        Foo[] list = new Foo[1000];
        
        
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
        	int iteration = 0;
            
           // count = 1;

            while ((line = br.readLine()) != null) {
            	if(iteration == 0) {
                    iteration++;  
                    continue;
                }
            	String[] country = line.split(cvsSplitBy);
            	
            	int flag = 0;
            	
            	// search through list to see if project number exists
            	
            	for(int i = 0; i < count; i++){
            		
            		// if project number exists, add scores to object
            		if(list[i].projectNumber.equals(country[2])){
            					
            			flag = 1;
            		
            			
            			list[i].sum += Integer.parseInt(country[14]);
            			list[i].sum += Integer.parseInt(country[5]);
            			list[i].sum += Integer.parseInt(country[6]);
            			list[i].sum += Integer.parseInt(country[7]);
            			list[i].sum += Integer.parseInt(country[8]);
            			list[i].sum += Integer.parseInt(country[9]);
            			list[i].sum += Integer.parseInt(country[10]);
            			list[i].sum += Integer.parseInt(country[11]);
            			list[i].sum += Integer.parseInt(country[12]);
            			list[i].sum += Integer.parseInt(country[13]);
            			list[i].numJudges += 1;
         
            		}
            	}
            	
            	// if a new project number
            	
            	if(flag == 0){
            		
            		list[count] = new Foo();
            		
            		list[count].projectNumber = country[2];
            		
            		list[count].category = country[3];
            		
            		list[count].gradeLevel = Integer.parseInt(country[4]);
            		
            		list[count].sum = Integer.parseInt(country[14]);
            		
            		list[count].sum += Integer.parseInt(country[5]);
            		
            		list[count].sum += Integer.parseInt(country[6]);
            		
            		list[count].sum += Integer.parseInt(country[7]);
            		
            		list[count].sum += Integer.parseInt(country[8]);
            		
            		list[count].sum += Integer.parseInt(country[9]);
            		
            		list[count].sum += Integer.parseInt(country[10]);
            		
            		list[count].sum += Integer.parseInt(country[11]);
            		
            		list[count].sum += Integer.parseInt(country[12]);
 
            		list[count].sum += Integer.parseInt(country[13]);
            		
            		list[count].numJudges = 1;
            		
            		count++;
            		
            	}
            	
    

                // use comma as separator

                //System.out.println("Country [code= " + country[1] + " , name=" + country[2] + "]");

            	
            }

        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
        }
        
        // take average score
    	for(int i = 0; i < count; i++){
    		
    		list[i].avg = (list[i].sum * 1.0) / (list[i].numJudges * 1.0);
    		
    		//System.out.println("Project number: " + list[i].projectNumber + " Sum of all scores " + list[i].sum + " number of judges: " + list[i].numJudges + " average: " + list[i].sum / list[i].numJudges);
    	}
    	
    	
    	Foo[] grade9 = new Foo[1000];
    	Foo[] grade10 = new Foo[1000];
    	Foo[] grade11 = new Foo[1000];
    	Foo[] grade12 = new Foo[1000];
    	Foo[] grade7 = new Foo[1000];
    	int grade7_count = 0;
    	int grade9_count = 0;
    	int grade10_count = 0;
    	int grade11_count = 0;
    	int grade12_count = 0;
    	
    	
    	Foo[] social = new Foo[1000];
    	Foo[] energy = new Foo[1000];
    	Foo[] chem = new Foo[1000];
    	Foo[] bio = new Foo[1000];
    	Foo[] physics = new Foo[1000];
    	
      	int social_count = 0;
    	int energy_count = 0;
    	int chem_count = 0;
    	int bio_count = 0;
    	int physics_count = 0;
    	
    	for(int i = 0; i < count; i++){
    		
    		if(list[i].gradeLevel == 7 || list[i].gradeLevel == 8){
    			
    			grade7[grade7_count] = list[i];
    			grade7_count++;
    			
    		}
    		
    		if(list[i].gradeLevel == 9){
    			
    			grade9[grade9_count] = list[i];
    			grade9_count++;
    			
    		}
    		if(list[i].gradeLevel == 10){
    			
    			grade10[grade10_count] = list[i];
    			grade10_count++;
    			
    		}
    		if(list[i].gradeLevel == 11){
    			
    			grade11[grade11_count] = list[i];
    			grade11_count++;
    			
    		}
    		if(list[i].gradeLevel == 12){
    			
    			grade12[grade12_count] = list[i];
    			grade12_count++;
    			
    		}
    		
    		if(list[i].category.equals("Energy-Engineering-Geology-Envi")){
    			
    			energy[energy_count] = list[i];
    			energy_count++;
    			
    		}
    		
    		if(list[i].category.equals("Chemistry")){
    			
    			chem[chem_count] = list[i];
    			chem_count++;
    			
    		}
    		
    		if(list[i].category.equals("Social Sciences")){
    			
    			social[social_count] = list[i];
    			social_count++;
    			
    		}
    		
    		if(list[i].category.equals("Biology")){
    			
    			bio[bio_count] = list[i];
    			bio_count++;
    			
    		}
    		
    		if(list[i].category.equals("Physics/Math")){
    			
    			physics[physics_count] = list[i];
    			physics_count++;
    			
    		}
    		
    	}
    	
    	
    	doInsertionSort(list);
    	doInsertionSort(grade7);
    	doInsertionSort(physics);
    	doInsertionSort(bio);
    	doInsertionSort(chem);
    	doInsertionSort(energy);
    	doInsertionSort(social);
    	
    
    	
        FileWriter fileWriter = null;
        int n = 1;
        
        try {
        	fileWriter = new FileWriter("results.csv");
        	fileWriter.append("TOP OVERALL SCORES (GRADE 7-12)");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Category, Number of judges");
        	fileWriter.append("\n");
        	for(int i = list.length - 1; i >= 0; i--){
        		if(list[i] != null){
        		fileWriter.append(n + "," + list[i].projectNumber.toString() + "," + list[i].gradeLevel + "," + list[i].avg + "," + list[i].category.toString() + "," + list[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        		// middle school
        	}
        	n = 1;
        	fileWriter.append("TOP OVERALL SCORES MIDDLE SCHOOL(GRADE 7 & 8)");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Category, Number of judges");
        	fileWriter.append("\n");
        	for(int i = grade7.length - 1; i >= 0; i--){
        		if(grade7[i] != null){
        		fileWriter.append(n + "," + grade7[i].projectNumber.toString() + "," + grade7[i].gradeLevel + "," + grade7[i].avg + "," + grade7[i].category.toString() + "," +  grade7[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        	}
        	
        	n = 1;
        	fileWriter.append("TOP 5 PHYSICS/MATH SCORES");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Number of judges");
        	fileWriter.append("\n");
        	for(int i = physics.length - 1; n <= 5; i--){
        		if(physics[i] != null){
        		fileWriter.append(n + "," + physics[i].projectNumber.toString() + "," + physics[i].gradeLevel + "," + physics[i].avg + "," + physics[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        	}
        	
        	n = 1;
        	fileWriter.append("TOP 5 BIOLOGY SCORES");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Number of judges");
        	fileWriter.append("\n");
        	for(int i = bio.length - 1; n <= 5; i--){
        		if(bio[i] != null){
        		fileWriter.append(n + "," + bio[i].projectNumber.toString() + "," + bio[i].gradeLevel + "," + bio[i].avg + "," + bio[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        	}
        	
        	n = 1;
        	fileWriter.append("TOP 5 CHEMISTRY SCORES");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Number of judges");
        	fileWriter.append("\n");
        	for(int i = chem.length - 1; n <= 5; i--){
        		if(chem[i] != null){
        		fileWriter.append(n + "," + chem[i].projectNumber.toString() + "," + chem[i].gradeLevel + "," + chem[i].avg + "," + chem[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        	}
        	
        	n = 1;
        	fileWriter.append("TOP 5 SOCIAL SCIENCES SCORES");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Number of judges");
        	fileWriter.append("\n");
        	for(int i = social.length - 1; n <= 5; i--){
        		if(social[i] != null){
        		fileWriter.append(n + "," + social[i].projectNumber.toString() + "," + social[i].gradeLevel + "," + social[i].avg + "," + social[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        	}
        	
        	n = 1;
        	fileWriter.append("TOP 5 ENERGY-ENGINEERING-GEOLOGY-ENVI SCORES");
        	fileWriter.append("\n");
        	fileWriter.append("\n");
        	fileWriter.append("Rank, Project Number, Grade, Avg Score, Number of judges");
        	fileWriter.append("\n");
        	for(int i = energy.length - 1; n <= 5; i--){
        		if(energy[i] != null){
        		fileWriter.append(n + "," + energy[i].projectNumber.toString() + "," + energy[i].gradeLevel + "," + energy[i].avg + "," + energy[i].numJudges);
        		fileWriter.append("\n");
        		n = n+1;
        		
        	}
        	}
        	
        } catch (IOException e){
        
        
    }
        finally {
        	
        	try{
        		fileWriter.flush();
        		fileWriter.close();
        	} catch (IOException e){
        		
        	}
        }
    	
    	

	}
	
    public static void doInsertionSort(Foo[] foo){
        
        Foo temp = new Foo();
        for (int i = 1; i < foo.length; i++) {
            for(int j = i ; j > 0 ; j--){
            	if(foo[j] != null){
                if(foo[j].avg < foo[j-1].avg){
                	System.out.println("test");
                    temp = foo[j];
                    foo[j] = foo[j-1];
                    foo[j-1] = temp;
                }
            	}
            }
        }
    }
	
	static void print3largest(Foo arr[], int arr_size)
    {
        int i;
		Foo third = new Foo();
		Foo second = new Foo();
		Foo first = new Foo();
		
		first.avg = 0;
        /* There should be atleast two elements */
        if (arr_size < 3)
        {
            System.out.print(" Invalid Input ");
            return;
        }
       
       // third.avg= first.avg = second.avg = null;
        for (i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than
            first*/
            if (arr[i].avg > first.avg)
            {
                third = second;
                second = first;
                first = arr[i];
            }
       
            /* If arr[i] is in between first and
            second then update second  */
            else if (arr[i].avg > second.avg)
            {
                third = second;
                second = arr[i];
            }
       
            else if (arr[i].avg > third.avg)
                third = arr[i];
        }
        
        System.out.println("First place: Project #" + first.projectNumber + "   Score:" + first.avg);
        
        System.out.println("Second place: Project #" + second.projectNumber + "   Score:" + second.avg);

        System.out.println("Third place: Project #" + third.projectNumber + "   Score:" + third.avg);

        

	


    }
}
