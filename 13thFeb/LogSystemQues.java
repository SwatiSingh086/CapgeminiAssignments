package HackerrankPractice;
import java.util.*;
import java.lang.*;
import java.io.*;


public class LogSystemQues {
	
	//logs=[["01-01-2023","14:00","ERROR","failed"]
	//,["01-01-2023","15:00","INFO","established"],
	// ["01-01-2023","01:30","ERROR","failed"],
	//["01-01-2023","14:00","ERROR","failed"]
	
	public static List<List<String>> extractErrorLogs(List<List<String>> logs){
		
		List<List<String>> filteredLogs= new ArrayList<>();
		for(List<String> log: logs) {
			String status= log.get(2);
			if(status.equals("ERROR") || status.equalsIgnoreCase("CRITICAL")) {
				filteredLogs.add(log);
			}
		}
		//yaha tak sirf error and critical waale aagaye
		
		//now we need to sort them by arrival time in ascending order
		
		filteredLogs.sort((a, b)->{
			
			String[] date1= a.get(0).split("-");
			String[] date2= b.get(0).split("-");
			
			
			int year1= Integer.parseInt(date1[2]);
			int year2= Integer.parseInt(date2[2]);
			if(year1!=year2) return Integer.compare(year1,year2);
			
			int month1= Integer.parseInt(date1[1]);
			int month2= Integer.parseInt(date2[1]);
			if(month1!=month2) return Integer.compare(month1,month2);
			
			int day1= Integer.parseInt(date1[0]);
			int day2= Integer.parseInt(date2[0]);
			if(day1!=day2) return Integer.compare(day1,day2);
			
			String[] time1= a.get(1).split(":");
			String[] time2= b.get(1).split(":");
			
			int hours1=Integer.parseInt(time1[0]);
			int hours2=Integer.parseInt(time2[0]);
			
			if(hours1!=hours2) return Integer.compare(hours1, hours2);
			
			int mins1=Integer.parseInt(time1[1]);
			int mins2= Integer.parseInt(time2[1]);
			if(mins1!=mins2) return Integer.compare(mins1, mins2);
			
			return 0;
			
		});
		
		return filteredLogs;
		
	}
	
	
	
	public static void main(String[] args) {
		List<List<String>> logs= new ArrayList<>();
		logs.add(Arrays.asList("01-01-2023","01:30","ERROR","failed"));
		logs.add(Arrays.asList("01-01-2023","14:00","ERROR","failed"));
		logs.add(Arrays.asList("01-01-2023","15:00","INFO","established"));
		
		List<List<String>> ans= LogSystemQues.extractErrorLogs(logs);
		
		System.out.println(ans);
		
		
		
		/*Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int cols=sc.nextInt();
		List<List<String>> logs= new ArrayList<>();
		for(int i=0;i<n;i++) {
			List<String> row= new ArrayList<>();
			for(int j=0;j<cols;j++) {
				row.add(Arrays.asList());
			}
		}*/
		
		
		
	}
}
