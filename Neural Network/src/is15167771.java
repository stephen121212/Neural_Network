import javax.swing.*;
import java.util.*;

public class is15167771{
	public static void main(String args[]){
		int G = 0;			//Number of generations
		int P = 0;			//Population size
		int S = 0;			//Number of students
		int E = 0;			//Total number of modules
		int C = 0;			//Number of modules
		int D = 0;			//Number of exam sessions/days
		int Cr = 0;			//Crossover Probability
		int Mu = 0;			//Mutation Probability
		int ED = 0;			//Number of exams per session
		int Re = 0;			//Reproduction Probability
		boolean Gnumber = false;
		boolean Pnumber = false;
		boolean Snumber = false;
		boolean Enumber = false;
		boolean Cnumber = false;
		boolean Dnumber = false;
		boolean Crnumber = false;
		boolean Munumber = false;
		int index = 0;
		int endingindex = 0;
		int fact = 1;
		boolean added = false;
		boolean moduleadded = false;
		Scanner s=new Scanner(System.in);
		
		//Loop for user to enter values
		do{ 
			try {
		 
					G =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Number of Generations:"));
					if(G>0)
					{
						Gnumber = true;
					}
				else{
						Gnumber = false;
					}
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
		}
	}while(!(Gnumber));
		
		
		
		
		
		do{ 
			try {
				S =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Number of Students:"));
				if(S>0)
				{
					Snumber = true;
				}
			else{
					JOptionPane.showMessageDialog(null,"Error: The number of students has to be a positive value(Greater than 0)");
					Snumber = false;
				}
			} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
			}
		}while(!(Snumber));
	
	
		
		
		
		
		do{ 
			try {
					E =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Total Number of Modules:"));
					if(E>0)
					{
						Enumber = true;
					}
				else{
						JOptionPane.showMessageDialog(null,"Error: The total number of modules has to be a positive value(Greater than 0)");
						Enumber = false;
					}
				} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
				}
		}while(!(Enumber));
			
			
			int number = E;
			fact = factorial(number);
			
			
		do{ 
			try {
					P =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Population Size:"));
					if(P>0 && P<=fact)
					{
						Pnumber = true;
					}
				else{
						JOptionPane.showMessageDialog(null,"The population size has to be a positive value(Greater than 0) and has to be less than E factorial(E!)");
						Pnumber = false;
					}
				} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
				}
		}while(!(Pnumber));	
			
			
		
			
			do{
				try {
						C =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Number of Modules:"));
						if(C>0 && C<E)
						{
							Cnumber = true;
						}
					else{
							JOptionPane.showMessageDialog(null,"Error: The number of modules has to be a positive value(Greater than 0) and be less than the total number of modules on the course");
							Cnumber = false;
						}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
				}
		}while(!(Cnumber));
		
			
			
		
			do{ 
				try {
							D =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Number of Exam Sessions:"));
							if(D>0)
							{
								Dnumber = true;
							}
						else{
								JOptionPane.showMessageDialog(null,"Error: The number of exam sessions has to be a positive value(Greater than 0) ");
								Dnumber = false;
							}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
				}
		}while(!(Dnumber));
		
		
			
			
			
			do{
				try {
						Cr =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Crossover Probability:"));
						if(Cr>0 && Cr<100)
						{
							Crnumber = true;
						}
					else{
							JOptionPane.showMessageDialog(null,"Error: The crossover probability has to be positive value(Greater than 0) and (less than 100)");
							Crnumber = false;
						}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
				}
		}while(!(Crnumber));
		
			
			
		
			do{ 
				try {
						Mu =Integer.parseInt(JOptionPane.showInputDialog("Please enter the Mutation Probability:"));
						if(Mu>0 && Mu<100)
						{
							Munumber = true;
						}
					else{
							JOptionPane.showMessageDialog(null,"Error: The mutation probability has to be positive value(Greater than 0) and (less than 100)");
							Munumber = false;
						}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error: The number of generations has to be a positive value(Greater than 0)");
				}
		}while(!(Munumber));
	
			
			
			
			
			
	
                ED = E/D; 		//Ceil of E/D
                Re = 100 - (Cr + Mu);	//Reproduction probability
		if((Re + Cr + Mu) != 100)
		{
			JOptionPane.showMessageDialog(null,"Error: The sum of Re, Cr and Mu does not equal to 100");
		}
		
		//Create array for two dimensional schedule
		ArrayList<ArrayList<Integer>> studentsschedule = new ArrayList<ArrayList<Integer>>();
		
			//Fill schedule with random modules using rows and columns
			for (int i = 0; i < S; i++)
			{
				studentsschedule.add(new ArrayList<Integer>());
				for(int j = 0; j<C; j++)
				{
					added = false;
					do{
						int random = (int) ((Math.random()*E)+1);
						if(!studentsschedule.get(i).contains(random))
						{
							studentsschedule.get(i).add(random);
							added = true;
						}
					}while(!added);
				}
			}
			
		//Print out values
		for(int i = 0; i <studentsschedule.size(); i++)
		{
			System.out.print("Student "+i+": " + (studentsschedule.get(i)).toString()+"\n");
		}
		
	       
	       //Wait for use to click enter 
	        System.out.println("Waiting for the end-user Enter to continue.....");
	        s.nextLine();
	        
	        System.out.println("Population");
	        System.out.println("\n");
	        
                        //Create array for two dimensional schedule
			ArrayList<ArrayList<Integer>> populationlist = new ArrayList<ArrayList<Integer>>();
			
			//Fill rows and columns with all modules randomly
			int i = 0;
			do {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for(int j = 0; j<E; j++)
					{
						moduleadded = false;
						do{
							int random = (int) ((Math.random()*E)+1);
							if(!temp.contains(random))
							{
								temp.add(random);
								moduleadded = true;
							}
						}while(!moduleadded);	
					}
					
					//Check if duplicate is found
					boolean duplicatefound = false;
					
					if(i > 0)
					{
							for(int a = 0; a<populationlist.size()&&!duplicatefound;a++)
							{
								duplicatefound = true;
								for(int b = 0; b<temp.size()&&duplicatefound;b++)
								{
									if(populationlist.get(a).get(b) != temp.get(b))
									{
										duplicatefound = false;
									}
								}
							}
					}
					
					
					
					if(!duplicatefound)
					{
						populationlist.add(temp);
						i++;
					}
				}while(populationlist.size()<P);
				
				
			
			
			
					//Breaking the ordering into segments
					int ordernumber = 0;
					ArrayList<Integer> fitnesslist = new ArrayList<Integer>();
                                        do {
						int fitness = 0;
						int overlap = 0;
						index = 0;
						for(int e = 1; e<= D; e++)
						{
							endingindex = ED*e;
							
							//Calculating the fitness cost
							for(int k = 0; k <studentsschedule.size(); k++)
							{
								if(populationlist.get(ordernumber).subList(index, endingindex).containsAll(studentsschedule.get(k)))
								{
									fitness++;
										if(fitness > 2)
										{
											overlap++;
										}
								}
							}
							index += ED;
						}
						System.out.print("Ordering: " + ordernumber + " " +populationlist.get(ordernumber)+ " "+ "Fitness Cost: " + overlap + "\n");
						fitnesslist.add(overlap);
						ordernumber++;
				}while(ordernumber < populationlist.size());
				
				int n = fitnesslist.size();
				int temp = 0;
				ArrayList<Integer> tempArr = new ArrayList<Integer>();
		            for (int pass=1; pass<n; pass++) // bubble sort outer loop
		            {
		                for (int compare=0; compare < n-pass; compare++) {
		                    if (fitnesslist.get(compare)>(fitnesslist.get(compare+1)))
		                    {
		                        temp = fitnesslist.get(compare+1);
		                        fitnesslist.set(compare+1,fitnesslist.get(compare) );
		                        fitnesslist.set(compare, temp);
		                        
		                        tempArr = populationlist.get(compare+1);
		                        populationlist.set(compare+1,populationlist.get(compare) );
		                        populationlist.set(compare, tempArr);
		                    }
		                }
		            }
		            
		            
		            //Get the worst fitness cost, average and best and replacing section 3 with section 1
		            int sizeofarraylist = 0;
		            for(int b = 0; b<populationlist.size();b++)
		            {
		            	sizeofarraylist++;
		            }
		            
		            int goodindex = sizeofarraylist/3*1;
		            int averageindex = sizeofarraylist/3*2;
		            int badindex = sizeofarraylist/3*3+1;
		            int beginningindex = 0; 
		            ArrayList<Integer> tempvalue = new ArrayList<Integer>();
		          
		            for(int a = beginningindex; a<=goodindex;)
		            {
		            	for(int b = averageindex; b<=badindex; b++)
		            	{
                                    tempvalue = populationlist.get(a);
                                    populationlist.set(b, tempvalue);
                                    a++;
		            	}
		            }

	
		            
                                //Assigning variables to Mutation, Reproduction or Crossover
				int random;
				random = (int)(Math.random()*100);
				ArrayList<Integer> window = new ArrayList<Integer>();
				ArrayList<Integer> window1 = new ArrayList<Integer>();
				ArrayList<Integer> window2 = new ArrayList<Integer>();
				int index1 = 0;
				int index2 = 0;
				
                                //Crossover code
				if(random>0 && random <= Cr)
				{	
                                        //Get population size
					int n1 = populationlist.size();
                                        //Get random schedules from the list
					int variable = (int)(Math.random()*n1);
					int variable1 = (int)(Math.random()*n1);
                                        //Get random number from those schedules
					int variable2 = (int)(Math.random()*populationlist.get(variable).size());
					int variable3 = (int)(Math.random()*populationlist.get(variable1).size());
					
                                        //Get the index of those variables
					index1 = populationlist.get(variable).get(variable2);
					index2 = populationlist.get(variable1).get(variable3);
                                        
                                        //If any of these occur
					if(index1<2 || index2<2 || index2>populationlist.get(variable1).size()-2 || index1 > populationlist.get(variable).size()-2) {
						//Get an index of different variables
                                                index1 = populationlist.get(variable).get(variable2);
						index2 = populationlist.get(variable1).get(variable3);
					}
					
					int beginning = 1;
					int d = 0;
                                        //Get size of schedules from the list
					int endingindex1 = populationlist.get(variable).size();
					int endingindex2 = populationlist.get(variable1).size();
					
                                        //Get two schedules and split them based of the index and swap the sublist from those indexes to the other schedules
					window2.addAll(populationlist.get(variable).subList(0, endingindex1));
					window.addAll(populationlist.get(variable).subList(beginning, index1));
					window1.addAll(populationlist.get(variable1).subList(beginning, index2));
					window1.addAll(populationlist.get(variable).subList(index1+1, endingindex1));
					window.addAll(populationlist.get(variable1).subList(index2+1, endingindex2));
					
					for(d = 0; d<E;d++)
					{
						d++;
					}
					
					for(int a = 0; a<window.size(); a++)
					{
						for(int b = 1; b<window.size(); b++)
						{
							for(int c = 1; c<window2.size(); c++)
							{
								if(a==b)
								{
									window.remove(a);
								}
							}
						}
					}
					
					if(!window.contains(d))
					{
						window.add(d);
					}
					
					populationlist.remove(variable);
					populationlist.remove(variable1);
					
					populationlist.add(window);
					populationlist.add(window1);
				}			
				
						
						
						
						
				//Mutation code
				else if(random>Cr && random <= Cr+Mu)
				{
                                        //Get two random variables from the same schedule and swap them
					int position = 0;
					int position1 = 0;
					int positionOfVariable1 = 0;
					int positionOfVariable2 = 0;
					int positionOfVariable3 = 0;
					int positionOfVariable4 = 0;
					int n1 = populationlist.size();
					int variable = (int)(Math.random()*n1);
					int k = (int)(Math.random()*populationlist.get(variable).size());
					int variable1 = (int)(Math.random()*populationlist.get(k).size());
					int variable2 = (int)(Math.random()*populationlist.get(k).size());
					int value1 = populationlist.get(k).get(variable1);
					int value2 = populationlist.get(k).get(variable2);
								
					if (populationlist.get(k).contains(variable1)) {
                                            for(int j = 0; j < populationlist.get(k).size(); j++) {
                                                if(populationlist.get(k).get(j) == variable1) {
                                                    position = j;
							break;
						}
                                            }
					}
					positionOfVariable1 = populationlist.get(k).get(position);
								
								
								
					if (populationlist.get(k).contains(variable2)) {
                                            for(int j = 0; j < populationlist.get(k).size(); j++) {

						if(populationlist.get(k).get(j) == variable2) {
						position1 = j;
						break;
						}
                                            }
					}
					positionOfVariable2 = populationlist.get(k).get(position1);
								
								
					if(populationlist.get(k).get(variable1) == populationlist.get(k).get(variable2))
					{
								
								
                                            int variable3 = (int)(Math.random()*populationlist.get(k).size());
                                            int variable4 = (int)(Math.random()*populationlist.get(k).size());
                                            int value3 = populationlist.get(k).get(variable3);
                                            int value4 = populationlist.get(k).get(variable4);
									
						if (populationlist.get(k).contains(variable3)) {
                                                    for(int j = 0; j < populationlist.get(k).size(); j++) {

							if(populationlist.get(k).get(j) == variable3) {
                                                            position = j;
								break;
							}
                                                    }
						}
						positionOfVariable3 = populationlist.get(k).get(position);
									
						if (populationlist.get(k).contains(variable4)) {
                                                    for(int j = 0; j < populationlist.get(k).size(); j++) {

							if(populationlist.get(k).get(j) == variable4) {
                                                            position1 = j;
                                                            break;
							}
                                                    }
						}
						positionOfVariable4 = populationlist.get(k).get(position);
									
						positionOfVariable4 = populationlist.get(k).get(position);
						populationlist.get(k).set(positionOfVariable3, value4);
						populationlist.get(k).set(positionOfVariable4, value3);	
					}
								
					else
					{
                                            populationlist.get(k).set(positionOfVariable1, value2);
                                            populationlist.get(k).set(positionOfVariable2, value1);		
                                    }
				}
				
				
				
				//Reproduction code
				else if(random>Cr+Mu && random<100)
				{
					
				}
				
				
				else
				{
                                    System.out.print("Error printing getting a random number"+ "\n");
				}
				
				for(int k = 0; k<populationlist.size() && k<=G; k++)
				{
                                    System.out.print("----------------------------------------------------------------------------" + "\n"+"Generation: " + k + "\n" + "Ordering: " +populationlist.get(k)+"\n" + "\n" + "Fitness Cost: " + fitnesslist.get(k) + "\n" +"\n"+"\n");
				}
	}

	

	
	
		//Method to calculate factorial
		 static int factorial(int n){    
			 if (n == 0)    
				 return 1;    
			 else    
				 return(n * factorial(n-1));    
		 }    
}