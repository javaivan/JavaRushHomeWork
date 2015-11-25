package com.javarush.test.level13.lesson11.home04;

import java.io.*;
/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

public class Solution
{
    public static void main(String[] args)
    {
	    try
	    {
		    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		    BufferedWriter writer =
				    new BufferedWriter( new OutputStreamWriter( new FileOutputStream( reader.readLine() ) ) );

		    String nextString;

		    do
		    {
			    nextString = reader.readLine();
			    writer.write( nextString );

			    if ( !nextString.equals( "exit" ) )
			    {
				    writer.newLine();
			    }
		    }
		    while ( !nextString.equals( "exit" ) );

		    reader.close();
		    writer.close();
	    }
	    catch ( IOException e )
	    {
		    e.printStackTrace();
	    }
    }
}
