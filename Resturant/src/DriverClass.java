import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverClass
{
	static String recieptFile="receiptFile.txt",line=null;
	static int count=0, maxCount;
	static PrintWriter textStream = textfile.createTextWrite(recieptFile);
	public static void main(String[]args) throws Exception
	{	//go to food item class for menu which comes from category classes
		//
		//then goto the gui and collect food order and add on to the orders or delete or search
		//order is then written into a file
		// store it into linked list classes? 
		//CategoryList ll = new CategoryList();
		//d.update();
		//GUIClass.Update button = d.new Update();
		DriverClass D= new DriverClass();
		DriverClass.foodGUI food = D.new foodGUI();
	}
	public class foodGUI
	{
		foodGUI()
		{
			System.out.println("foodGUI");
			GUIClass d= new GUIClass();
			d.Search();
		}
	}
	public static class textfile
	{

		textfile() throws Exception
		{//build food
			maxCount=count;
			System.out.println("textfile method");
			Scanner scanFile= textfile.createTextRead(recieptFile);
			for(count=1;count< maxCount;count++)//fix limit
			{
				System.out.println("count= "+count);
				count=scanFile.nextInt();
				line = scanFile.nextLine();
				if(line==null)
				{
					DriverClass D= new DriverClass();
					DriverClass.excelfile food = D.new excelfile();
				}
				System.out.println(count + line);
			}scanFile.close();
			//GUIClass d= new GUIClass();
			//GUIClass.buttonAction button = d.new buttonAction();
			//scanFile.close();
			DriverClass D= new DriverClass();
			DriverClass.excelfile food = D.new excelfile();
		}
		public static PrintWriter createTextWrite(String S)
		{
			//textStream.close();
			PrintWriter TStream=null;
			try
			{
				TStream= new PrintWriter(new FileOutputStream(S));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file in createTextWrite "+S.toString());
			}
			return TStream;
		}
		public static Scanner createTextRead(String S)
		{
			Scanner textFile=null;
			try 
			{
				textFile= new Scanner(new FileInputStream(new File(S)));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("file not found "+S.toString());
				System.out.println("or could not be opened. "+S.toString());
			}
			return textFile;
		}
	}
	public class excelfile
	{
		excelfile() throws Exception
		{
			System.out.println("excelfilemethod");
			ReadExcel read= new ReadExcel();
		}	
	}
}