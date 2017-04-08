package oop_cw2_exp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class GUIapplication {
	private JLabel s1, s2, s3, s4, s5, s6, s7;
	JLabel creditText, betText;
	static int creditCount=10; // initial credit value is 10
	static int betCount; //stores the value of current bet
	static int losesCount, winCount;
	static int verify=0; //verify if the user has got exactly 2 images the same at the free spinning chance given

	
	JButton reel1, reel2, reel3; // for 3 images
	
			public void display(){
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame frame= new JFrame("Slot machine");
			
			JPanel panel= new JPanel (new GridLayout(6,1));
			JPanel panel1= new JPanel ();
			JPanel panel2= new JPanel ();
			JPanel panel3= new JPanel ();
			JPanel panel4= new JPanel ();
			JPanel panel5= new JPanel ();
			//JPanel panel6= new JPanel ();
			JPanel panel7= new JPanel ();
			JButton spin= new JButton("Spin");
			s7= new JLabel("       ");
			spin.addActionListener(new SpinListener() );
			ImageIcon reel= new ImageIcon(getClass().getResource("newredseven.png"));
			Image image= reel.getImage();
			//Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			reel = new ImageIcon(image);
			reel1= new JButton(reel);
			
			s1= new JLabel("       ");
			ImageIcon reell= new ImageIcon(getClass().getResource("newredseven.png"));
			Image image1= reell.getImage();
			//Image newimg1 = image1.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			reell = new ImageIcon(image1);
			reel2= new JButton(reell);
			s2= new JLabel("       ");
			ImageIcon reelll= new ImageIcon(getClass().getResource("newredseven.png"));
			Image image3= reelll.getImage();
			//Image newimg3 = image3.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			reelll = new ImageIcon(image3);
			reel3= new JButton(reelll);
			
			JButton addCoin= new JButton("Add coin");
			addCoin.addActionListener(new AddCoinListener() );
			JLabel creditArea= new JLabel ("Credit Area");
			creditText= new JLabel("10");
			s3= new JLabel("                                                            ");
			s4= new JLabel("                   ");
			JButton betOne= new JButton("Bet one");
			betOne.addActionListener(new BetOneListener());
			s5= new JLabel("       ");
			JButton betMax= new JButton("Bet max");
			betMax.addActionListener(new BetMaxListener());
			JLabel betArea= new JLabel ("Bet Area");
			betText= new JLabel();
			JButton reset= new JButton("Reset");
			s6= new JLabel("       ");
			reset.addActionListener(new ResetListener());
			JButton statistics= new JButton("Statistics");
			statistics.addActionListener(new StatisticsListener());
			frame.add(panel);
			panel.add(panel1);
			panel.add(panel2);
			panel.add(panel3);
			panel.add(panel4);
			panel.add(panel5);
			//panel.add(panel6);
			panel.add(panel7);
			panel1.add(spin);
			panel1.add(s7);
			panel2.add(reel1);
			panel2.add(s1);
			panel2.add(reel2);
			panel2.add(s2);
			panel2.add(reel3);
			panel2.add(s4);
			panel1.add(addCoin);
			panel4.add(creditArea);
			panel4.add(creditText);
			panel5.add(betOne);
			panel5.add(s5);
			panel5.add(betMax);
			panel4.add(s3);
			panel4.add(betArea);
			panel4.add(betText);
			panel7.add(reset);
			panel7.add(s6);
			panel7.add(statistics);
			frame.setSize(620,700);
			//frame.pack();
			
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

	}
		class AddCoinListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//incrementing the credit count when coins are added
				creditCount= creditCount+1;
				creditText.setText(""+creditCount);
				
			}
			
		}
		class BetOneListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if (creditCount>0){
				// incrementing the bet count 
				betCount= betCount+1;
				creditCount= creditCount-1;
				creditText.setText(""+ creditCount);
				betText.setText(""+ betCount);
				} else {
					JOptionPane.showMessageDialog(null, "Insufficient credit. Please add coins.");
				}
				
			}
			
		}
		class BetMaxListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if (creditCount>=3){
				//using bet max button you can bet 3 credits from a single click
				betCount= betCount+3;
				creditCount= creditCount-3;
				creditText.setText(""+ creditCount);
				betText.setText(""+ betCount);
				}else {
					JOptionPane.showMessageDialog(null, "Insufficient credit. Please add coins.");
				}
				
			}
			
		}
		class ResetListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				creditCount= creditCount+betCount;
				betCount= 0;
				creditText.setText(""+ creditCount);
				betText.setText(""+ betCount);
				
			}
			
		}
		class SpinListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if (creditCount<1){
					JOptionPane.showMessageDialog(null, "No credits left. Please add coins.");
				}
				else if (betCount<1){
					JOptionPane.showMessageDialog(null, "No current bet. Please add a bet.");
				}
				else {
					//creating 3 reel objects
					
					/*Reel r1= new Reel();
					Reel r2= new Reel();
					Reel r3= new Reel();

					r1.run();
					new Thread(r1).start();
					ISymbol firstReel = r1.spin();

					r2.run();
					new Thread(r2).start();
					ISymbol secondReel = r2.spin();

					r3.run();
					new Thread(r3).start();
					ISymbol thirdReel = r3.spin();
					
					
					
					reel1.setIcon(new ImageIcon(firstReel.getImage()));
					System.out.println(firstReel.getValue());
					
					
					reel2.setIcon(new ImageIcon(secondReel.getImage()));
					System.out.println(secondReel.getValue());
					
					reel3.setIcon(new ImageIcon(thirdReel.getImage()));
					System.out.println(thirdReel.getValue());
					System.out.println();*/
					
					Reel r1= new Reel();
					Reel r2= new Reel();
					Reel r3= new Reel();
					
					
					new Thread() {
						@Override
						public void run() {
							ISymbol firstReel = null;
							ISymbol thirdReel = null;
							ISymbol secondReel = null;
							while (true) {
								Thread threadReel1 = new Thread(r1);
								Thread threadReel2 = new Thread(r2);
								Thread threadReel3 = new Thread(r3);
								threadReel1.start();
								threadReel2.start();
								threadReel3.start();

								try {
									threadReel1.join();
									threadReel2.join();
									threadReel3.join();
									//join waits till all 3 threads finish its execution
									
									
									firstReel = r1.spin();
									thirdReel = r3.spin();
									secondReel = r2.spin();
									methodtosetimages(firstReel,secondReel,thirdReel);

									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								//checks if a reel is clicked
								if(reel1.getModel().isPressed()|| reel2.getModel().isPressed()||reel3.getModel().isPressed()){
									break;
								}
							}
							
							/*
							 * if all 3 images are equal the user wins the game. Winning credits are added to the credit area
							 * if only 2 images are equal the user gets the chance to spin the reel again
							 * if all 3 images are different the user looses the bet credits
							 * 
							 * 
							 */
							
							int winCredit=0; //stores the winning number of credits
							if( firstReel.getImage().equals(secondReel.getImage()) && secondReel.getImage().equals(thirdReel.getImage()) ){
								//when the user wins
								winCredit= firstReel.getValue()* betCount;
								creditCount+= winCredit;
								creditText.setText(""+creditCount);
								betCount=0;
								betText.setText(""+0);
								JOptionPane.showMessageDialog(null, "Congratulations! you won "+ winCredit+" credits");
								winCount++;
							}
							else if(firstReel.getImage().equals(secondReel.getImage()) || secondReel.getImage().equals(thirdReel.getImage()) || thirdReel.getImage().equals(firstReel.getImage())){
								//user getting another free chance to spin
								if (verify==0){
									JOptionPane.showMessageDialog(null, "2 images are equal. Therefore you get another free chance to spin");
									verify++;	
								}else{
									// user has lost his/her bet. The bet will remain in the machine
									betCount=0;
									betText.setText(""+0);
									JOptionPane.showMessageDialog(null, "You lost.");
									losesCount++;
									verify=0;
								}
							}
							else{
								// user has lost his/her bet. The bet will remain in the machine
								betCount=0;
								betText.setText(""+0);
								JOptionPane.showMessageDialog(null, "You lost.");
								losesCount++;
							}

						}

					}.start();
					
				}
					
				
			}
			
			//setting images to the 3 reels
			public void methodtosetimages(ISymbol firstReel, ISymbol secondReel, ISymbol thirdReel){
				reel1.setIcon(new ImageIcon(firstReel.getImage()));
				System.out.println(firstReel.getImage());
				
				reel2.setIcon(new ImageIcon(secondReel.getImage()));
				System.out.println(secondReel.getImage());

				reel3.setIcon(new ImageIcon(thirdReel.getImage()));
				System.out.println(thirdReel.getImage());
				System.out.println();
			}
			
		}
		
		class StatisticsListener implements ActionListener{
			JFrame statFrame;
			JLabel wins,winsText, losesText, loses, averageText,average;
			JButton statButton;
			JPanel statPanel, statPanel1, statPanel2,statPanel3,statPanel4;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//creating the statistics window
				JFrame.setDefaultLookAndFeelDecorated(true);
				statFrame= new JFrame("Statistics Window");
				statPanel= new JPanel(new GridLayout(4,1));
				statPanel1= new JPanel();
				wins= new JLabel("No. of wins:   ");
				winsText= new JLabel(""+ winCount);
				statPanel2= new JPanel();
				loses= new JLabel("No. of loses:   ");
				losesText= new JLabel(""+ losesCount);
				statPanel3= new JPanel();
				average= new JLabel("Average no. of credits netted per game:   ");
				double avg= creditCount *1.0/ (losesCount+ winCount)*1.0;
				if (losesCount+ winCount==0){
					avg=0;
				}
				averageText= new JLabel(""+avg);
				statPanel4= new JPanel();
				statButton= new JButton ("Save Statistics");
				String message="No. of wins: "+winCount+" \tNo. of loses: "+losesCount+" \tAverage no. of credits netted per game: "+avg;
				statButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							//getting the current system date and time
							String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
							PrintWriter pw = new PrintWriter(timeStamp+".txt");
							pw.println(message);
							System.out.println("File Saved");
							pw.close();
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(null,"No Such file found","Error!",JOptionPane.ERROR_MESSAGE);
							
						}
						System.exit(0);
					}
				});
				statFrame.add(statPanel);
				statPanel.add(statPanel1);
				statPanel.add(statPanel2);
				statPanel.add(statPanel3);
				statPanel.add(statPanel4);
				statPanel1.add(wins);
				statPanel1.add(winsText);
				statPanel2.add(loses);
				statPanel2.add(losesText);
				statPanel3.add(average);
				statPanel3.add(averageText);
				statPanel4.add(statButton);
				statFrame.setSize(450,250);
				statFrame.setVisible(true);
				
			}
		}

}
