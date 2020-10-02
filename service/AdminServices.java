package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

public class AdminServices {

	User user=null;
	public void dispList(List<User> userlist) {
		if(userlist.size()>0)
		{
			System.out.println("Index\t\tUserName\t\tPhone\t\tAddress\t\t\tProof ID\t\t\tBalance");
			System.out.println("*******************************************************************************************************************************");
		for(int i=0;i<userlist.size();i++)
		{
			user=userlist.get(i);
			
			
			System.out.println(i+")\t"+user.getUserName()+"\t\t"+user.getPhoneNumber()+"\t\t"+user.getAddress()+"\t\t"+user.getProofId()+"\t\t"+user.getBankBalance());
			System.out.println("*******************************************************************************************************************************");
		}
		}
		else {
			System.out.println("❎ No users to display");
		}
		
	}
	
	public void LoanReq(HashMap<String, User> loans) {
		
		// iterating using for loop.
		if(loans.size()>0)
		{
				for (Map.Entry<String, User> item : loans.entrySet()) {
					System.out.println("UserName\t\tBalance\t\tloan status\t\tRequestedLoan\t\tAproved Loan");
					System.out.println("****************************************************************************************************");
				    System.out.println(item.getKey() + "\t\t\t" + item.getValue().getBankBalance()+ "\t\t\t" +item.getValue().getLoanStatus()+ "\t\t\t"+item.getValue().getRequestedLoan()+ "\t\t\t"+item.getValue().getApprovedLoan());
				}
		}
		else {
			System.out.println("❎ No users to display");
		}
	
	}
	
	public void approveLoan(String user2,List<User> userlist,long approvdAmt) {
		boolean userFound=false;
		for(int i=0;i<userlist.size();i++)
		{
			user=userlist.get(i);
			if(user.getUserName().contentEquals(user2))
			{
				userFound=true;
				System.out.println("Loan requested: "+user.getRequestedLoan());
				long avblBalance = user.getBankBalance();
				user.setLoanStatus("✔ Aproved");
				user.setApprovedLoan(approvdAmt);
				user.setBankBalance(avblBalance+approvdAmt);
				System.out.println("✔ Loan Approved for :"+user2 +" of amount "+approvdAmt);
			}
		}
		
		if (!userFound) {
			System.out.println("❎ User Not found");
			
		}
		
	}
	
	public void getUserById(List<User> usersList,int index)
	{
		int id=index;
		user=usersList.get(id);
		System.out.println("Index\t\tUserName\t\tPhone\t\tAddress\t\tProof ID\t\tBalance");
		System.out.println("******************************************************************************************************************************");
		
		System.out.println(id+")\t\t"+user.getUserName()+"\t\t"+user.getPhoneNumber()+"\t\t"+user.getAddress()+"\t\t"+user.getProofId()+"\t\t"+user.getBankBalance());
		System.out.println("************************************************************************************************************************************");
		
	}
	public void display(List<User> usersList,String s)
	{System.out.println("Index\t\tUserName\t\tPhone\t\tAddress\t\tProof ID\t\tBalance");
	System.out.println("*************************************************************************************************************************");
	
		for(int i=0;i<usersList.size();i++)
		{
			String hint=s;
			user=usersList.get(i);
			if(user.getUserName().contentEquals(hint)||user.getPhoneNumber().contentEquals(hint)) 
			{
			System.out.println(i+")\t\t"+user.getUserName()+"\t\t"+user.getPhoneNumber()+"\t\t"+user.getAddress()+"\t\t"+user.getProofId()+"\t\t"+user.getBankBalance());
			System.out.println("****************************************************************************************************************************");
		}
			else
			{
				System.out.println("❎ No match found");
		      }
		
		}
	}
	public void updateAddress(String newAdd)
	{
		String newAddress=newAdd;
		user.setAddress(newAddress);
	}
	
	public void updatePhoneNumber(String phone)
	{
		String newMobile=phone;
		user.setPhoneNumber(newMobile);
	}
	
	public void delete(List<User> usersList,String remove)
	{
		String delete=remove;
		for(int i=0;i<usersList.size();i++)
		{
			user=usersList.get(i);
			if(user.getUserName().contentEquals(delete)||user.getPhoneNumber().contentEquals(delete)||user.getProofId().contentEquals(delete))
			{
			user=usersList.remove(i);
			System.out.println("✔ User deleted");
			}
			else
				System.out.println("❎ User not found");
		}
	}

}
