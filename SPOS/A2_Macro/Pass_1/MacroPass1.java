import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MacroPass1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("D:\\Sem 5 Study Material\\LP 1\\LP 1\\SPOS\\A2_Macro\\Pass_1\\macro_input.asm"));
		
		FileWriter mnt=new FileWriter("mnt.txt");
		FileWriter mdt=new FileWriter("mdt.txt");
		FileWriter kpdt=new FileWriter("kpdt.txt");             // keyword parameter 
		FileWriter pnt=new FileWriter("pntab.txt");             // positional 
		FileWriter intermediate=new FileWriter("intermediate.txt");
		LinkedHashMap<String, Integer> pntab=new LinkedHashMap<>();      // parameter name table
		String line;
		String Macroname = null;
		int mdtp=1,kpdtp=0,paramNo=1,pp=0,kp=0,flag=0;
		while((line=br.readLine())!=null)
		{
			
			String parts[]=line.split("\\s+");
			if(parts[0].equalsIgnoreCase("MACRO"))
			{
				flag=1;
				line=br.readLine();
				parts=line.split("\\s+");
				System.out.println("Hello");
				System.out.println(parts[0]+ " " + parts[1]);
				Macroname=parts[0];
				if(parts.length<=1)
				{
					mnt.write(parts[0]+"\t"+pp+"\t"+kp+"\t"+mdtp+"\t"+(kp==0?kpdtp:(kpdtp+1))+"\n");
					continue;
				}
				for(int i=1;i<parts.length;i++) //processing of parameters
				{
					parts[i]=parts[i].replaceAll("[&,]", "");
					// System.out.println(parts[i]);
					if(parts[i].contains("="))
					{
						++kp;
						String keywordParam[]=parts[i].split("=");
						pntab.put(keywordParam[0], paramNo++);
						if(keywordParam.length==2)
						{
							kpdt.write(keywordParam[0]+"\t"+keywordParam[1]+"\n");
							// System.out.println(keywordParam[0] +" "+ keywordParam[1]);
						}
						else
						{
							kpdt.write(keywordParam[0]+"\t-\n");
							System.out.println(keywordParam[0]);
						}
					}
					else
					{
						pntab.put(parts[i], paramNo++);
						pp++;
					}
				}
				mnt.write(parts[0]+"\t"+pp+"\t"+kp+"\t"+mdtp+"\t"+(kp==0?kpdtp:(kpdtp+1))+"\n");

				kpdtp=kpdtp+kp;
				//System.out.println("KP="+kp);
				
				
			}
			else if(parts[0].equalsIgnoreCase("MEND"))
			{
				mdt.write(line+"\n");
				flag=kp=pp=0;
				mdtp++;
				paramNo=1;
				pnt.write(Macroname+":\t");
				Iterator<String> itr=pntab.keySet().iterator();
				while(itr.hasNext())
				{
					pnt.write(itr.next()+"\t");
				}
				pnt.write("\n");
				pntab.clear();
			}
			else if(flag==1)
			{
				for(int i=0;i<parts.length;i++)
				{
					if(parts[i].contains("&"))
					{
						parts[i]=parts[i].replaceAll("[&,]", "");
						mdt.write("(P,"+pntab.get(parts[i])+")\t");
					}
					else
					{
						mdt.write(parts[i]+"\t");
					}
				}
				mdt.write("\n");
				mdtp++;
			}
			else
			{
				intermediate.write(line+"\n");
			}
		}
		br.close();
		mdt.close();
		mnt.close();
		intermediate.close();
		pnt.close();
		kpdt.close();
		System.out.println("Process Completed");
	}

}
