package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;
public class Bank_services
{
		static List<User> users=new ArrayList<User>();
		static HashMap<String,User> loans= new HashMap<String, User>();
		
		public List<User> addUser(User user)
		{
			users.add(user);
			System.out.println("Adding user");
			return users;
			
		}
		public long deposit(User user,long deposit) {
			
			long avblBalance = user.getBankBalance();
			user.setBankBalance(avblBalance+deposit);
			return avblBalance+deposit;
		}
		
		public String withDraw(User user,long withdraw) {
				
				long avblBalance = user.getBankBalance();
				if(avblBalance<withdraw)
				{
					return "You don't have that much money man";
				}
				else {
					user.setBankBalance(avblBalance-withdraw);
					return "Updated balance "+String.valueOf(avblBalance-withdraw);
				}
				
			}
		
		public HashMap<String, User> applyLoan(User user,HashMap<String, User> loans,long reqAmount) {
			long avblBalance = user.getBankBalance();
			if(avblBalance>=5000 && user.getLoanStatus().contentEquals("N/A"))
			{
				user.setLoanStatus("Pending");
				user.setRequestedLoan(reqAmount);
				
			System.out.println("Loan has Applied wait for approval");
			loans.put(user.getUserName(), user);
			return loans;
			}
			else if(user.getLoanStatus().contains("Aproved")) {
				System.out.println("Your Loan Has Approved");
				return loans;
			}
			else {
				System.out.println("Minimum Balance to apply loan is 5000");
				return loans;
				
			}
			
		}
		
		
}
