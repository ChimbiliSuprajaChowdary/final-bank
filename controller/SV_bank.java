package controller;
import model.Admin;
import model.User;
import service.AdminServices;
import service.Bank_services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import businesslogic.UserValidations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SV_bank {

	static List<User> usersList=new ArrayList<User>();
	static HashMap<String,User> loans= new HashMap<String, User>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		Bank_services service=new Bank_services();
		UserValidations validation = new UserValidations();
		AdminServices adminServices = new AdminServices();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean success = false;
		User testUser = new User("vamshi","vamshi",44,"asd","asd","asd",80000);
		User testUser2 = new User("test","vamshi",44,"asd","asd","asd",80000);
		usersList.add(testUser);
		usersList.add(testUser2);
		while (!success) {
		try {
		do {
			System.out.println("\t\t\t\t\t\tWELCOME");
			System.out.println("---------------------------------------––––•(-• SV Bank •-)•–-----------------------------------------------------------–––---");
			System.out.println("1.Admin");
			System.out.println("2.User Login");
			System.out.println("3.Apply for bank account");
			System.out.println("\n➡Enter your choice");
			int choice = Integer.parseInt(br.readLine());
			
//			for (Map.Entry<String, User> item : loans.entrySet()) {
//				System.out.println("map loop");
//			    System.out.println(item.getKey() + " = " + item.getValue());
//			}
				switch(choice) {
				case 1: 
				{
					Admin admin=new Admin();
					String adminName;
					String password;
					Boolean notFounBoolean=false;
					System.out.println("➡Enter your username");
					adminName=br.readLine();
					System.out.println("➡Enter your password");
					password=br.readLine();
					if(adminName.contentEquals(admin.getUserName()) && password.contentEquals(admin.getPassword()))
					{
						int operation;
						System.out.println("-–------------------------------–––•(-• Welcome Admin •-)•–---------------------------------------------------------------");
						AdminServices admins=new AdminServices();
						do
						{
							User user=null;
							System.out.println("\n1.Get all users details\n2.Get details by name or phone number"
									+ "\n3.Update user details\n4.Delete user \n5.Loan Requests \n6.Accept Loans(by username) \n7.Log Out");
							operation=Integer.parseInt(br.readLine());
							switch(operation)
							{
							case 1:
							{
									notFounBoolean=false;
									adminServices.dispList(usersList);
									break;
							}
							case 2:
							{
								notFounBoolean=false;
								System.out.println("➡Enter name or phone number");
								String hint=br.readLine();
								if(usersList.size()!=0) {
									admins.display(usersList,hint);
								}
								else
								{
									System.out.println("❎ Empty record");
								}
				
								break;
							}
							case 3:
							{
								notFounBoolean=false;
								System.out.println("➡Select what do you want to update");
								int update,id;
								if(usersList.size()!=0) {
								do {
									
									System.out.println("0.Go back to the main menu");
									System.out.println("1.Update address");
									System.out.println("2.Update mobile number");
									System.out.println("\n➡Enter your choice");
									update = Integer.parseInt(br.readLine());
									switch(update) 
									{
									case 1:
									{	
										System.out.println("➡Get user detail by Id");
										id=Integer.parseInt(br.readLine());
										admins.getUserById(usersList, id);
										System.out.println("➡Enter new address");
										String newAddress=br.readLine();
										admins.updateAddress(newAddress);
										admins.getUserById(usersList, id);
										break;
									}
									case 2:
									{
										System.out.println("➡Get user detail by Id");
										id=Integer.parseInt(br.readLine());
										admins.getUserById(usersList, id);
										System.out.println("➡Enter new mobile number");
										
										String newMobile;
										do {
											
											newMobile=br.readLine();
											System.out.println(validation.phoneNumberWarrning(validation.isNumber(Long.parseLong((newMobile)))));
									}
									while(!validation.isNumber(Long.parseLong((newMobile))));
										
										
										admins.updatePhoneNumber(newMobile);
										admins.getUserById(usersList, id);
										break;
									}
									
									default:
									{
										System.out.println("❎Choose correct option");
										break;
									}
								}
									
									
								}while(update!=0);
								}
								else
								{
									System.out.println("❎ Empty record");
								}
							break;	
							}
							case 4:
							{
								notFounBoolean=false;
								System.out.println("➡Enter name, mobile number or proof Id to delete user");
								String delete=br.readLine();
								if(usersList.size()!=0) {
									admins.delete(usersList, delete);
								}
								else
								{
									System.out.println("❎ Empty record");
								}
								break;
							}						
							
							case 5:
								notFounBoolean=false;
								
								adminServices.LoanReq(loans);
								
								break;
							case 6:
								notFounBoolean=false;
								System.out.println("➡Enter Loan Approved UserName");
								String userNameString =br.readLine();
								System.out.println("➡Enter Loan approved Amount"); 
								long aprovedAmt= Long.parseLong(br.readLine());
								adminServices.approveLoan(userNameString,usersList,aprovedAmt);
								break;
								
							case 7:{
								notFounBoolean=true;
								System.out.println("✔ Logged out");
								
								break;
							}
							default:
							{
								System.out.println("❎ Access denied!!");
								break;
							}
						}
						
						}while(!notFounBoolean);
				}
					else
					{
						System.out.println("❎ Access denied!!");
					}
					}
				  break;
				case 2:
				{
					//User testUser ;
					
					String userName;
					String userpassword;
					//user.setUserName(userName);
					
					System.out.println("➡Enter your username");
					userName=br.readLine();
				
					System.out.println("➡Enter your password");
					userpassword=br.readLine();
					
					//testUser.setUserName(userName);
					//testUser.setPassword1(userpassword);
					Boolean notFounBoolean=false;
					boolean isBreakTheLoop = false;
					for(int i=0;i<usersList.size();i++)
					{
						testUser=usersList.get(i);
						if(testUser.getUserName().contentEquals(userName) && testUser.getPassword1().contentEquals(userpassword))
						{
							notFounBoolean=true;
							System.out.println("\n-–--––--------------------------------–•(-• Welcome "+testUser.getUserName()+" •-)•–----------------------------------------\n");
							do
							{
								System.out.println("\n1.Deposit money\n2.Withdraw money"
										+ "\n3.Apply for loan \n4.Get Current balance  \n6.Loan Status \n7.Logout");
								int operation=Integer.parseInt(br.readLine());
								switch(operation)
								{
								case 1:
								{
									isBreakTheLoop=false;
									System.out.println("➡Enter your amount :");
									long deposit= Long.parseLong(br.readLine());
									deposit = service.deposit(testUser, deposit);
									System.out.println("✔Your updated balance:"+testUser.getBankBalance());
									break;
								}
								case 2:
								{
									isBreakTheLoop=false;
									System.out.println("➡Enter your Withdrawal amount :");
									long withdraw= Long.parseLong(br.readLine());
									String res = service.withDraw(testUser, withdraw);
									
									System.out.println(res);
									System.out.println("✔Your current balance "+testUser.getBankBalance());
									break;
									
									
								}
								case 3:
								{
									isBreakTheLoop=false;
									System.out.println("✔Enter Amount of loan You want");
									long reqAmount =Long.parseLong(br.readLine());
									
									 loans = service.applyLoan(testUser,loans,reqAmount);
									//System.out.println(loanString);
									System.out.println("✔Your current balance "+testUser.getBankBalance());
									break;
								}
								
								case 4:
								{
									isBreakTheLoop=false;
									System.out.println("✔ Your current balance "+testUser.getBankBalance());
									break;
									
								}
								case 5:
									System.out.println("Loan Status: "+testUser.getLoanStatus());
									break;
								case 6:
									isBreakTheLoop=true;
									System.out.println("✔ Logged out");
									break;
								default:
								{
									System.out.println("❎ Choose correct option");
									break;
								}
								}
							
							}while(!isBreakTheLoop);
						}
						
						
					}
					if (!notFounBoolean) {
						System.out.println("❎ User not found");
					}
					
				}
				  break;
				case 3:
				{
					//System.out.println(validation.isNumber(Long.pars("630071328")));
					String	phoneNumber,password1;
					int age;
					
					System.out.println("\nFill the application:");
					System.out.println("➡Enter your name:");
					String userName=br.readLine();
					System.out.println("➡Create a password:");
					do {
						 password1=br.readLine();
						 System.out.println(validation.passwordWarrining((validation.isValidPassword(password1))));
					} while (!validation.isValidPassword(password1));
					
					System.out.println("➡Your age:");
					do {
						age=Integer.parseInt(br.readLine());
						System.out.println(validation.isAgeWarning((validation.isAge(age))));
					} while (!validation.isAge(age));
					
					
					
					System.out.println("➡Enter your mobile number");
					do {
							
							phoneNumber = br.readLine();
							System.out.println(validation.phoneNumberWarrning(validation.isNumber(Long.parseLong((phoneNumber)))));
					}
					while(!validation.isNumber(Long.parseLong((phoneNumber))));
					
					//System.out.println(validation.isNumber(Integer.parseInt(phoneNumber)));
					
					
					System.out.println("➡Enter your address");
					String address=br.readLine();
					System.out.println("➡Any proof ID - with Proof Name");
					String proofId=br.readLine();
					System.out.println("➡How much do you want deposit ?");
					long bankBalance=Long.parseLong(br.readLine());
					
					User user=new User();
					
					user.setUserName(userName);
					user.setPassword1(password1);
					user.setAge(age);
					user.setPhoneNumber(phoneNumber);
					user.setAddress(address);
					user.setProofId(proofId);
					user.setBankBalance(bankBalance);
					//admin validation
					usersList=service.addUser(user);
					System.out.println("✔ Account Created");
					break;
				}
				}
				
			}
		while(true);
		
		}
			
				
			 catch (Exception e) {
				System.out.println("❎ "+e);
			}
			
			}
			
		
		

		}
}