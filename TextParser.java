import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLDocument;

//HTMLDocument API: https://docs.oracle.com/javase/8/docs/api/javax/swing/text/html/HTMLDocument.html
//Pattern API + Regex: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

/**
 * @author Kayla Tucker, [anyone who reads this mess]
 * @version 1.0 (Pre-Alpha)
 */
public class TextParser
{
	//Scanner
	private Scanner scan;
	//regex patterns that match markdowns
	private final Pattern emptyLn = Pattern.compile( "(\\t|\\n|\\s)+" );
	private Pattern heading_1, heading_2, heading_3, bold, italic, blockquote, 
		ordered_list, unordered_list, code, horizontal_rule, link, image;
	private Pattern[] patterns;
	private JEditorPane p;
	private HTMLDocument htmldoc;
	

	public void main( String[] args )
	{
		//self-explanatory for private local variables
		initialize();

		//scanning is dangerous ok im scawred
		try
		{
			//TODO change file location later 
			// - this needs to be linked to the webpage file asset somehow
			File f = new File( "./src/Map.txt" ); 
			scan = new Scanner( f );

			//grab the new html file returned from the coversion
			File html = toHTML( scan );
		}
		catch ( Exception e ) { System.out.print( e ); } finally
		{
			//scanner no more scanning
			if ( scan != null )
			{
				scan.close();
			}
		}
	}

	/**
	 * Pattern matching for markdowns in .txt document
	 */
	public void initialize()
	{
		//these can definitely be improved
		//btw this cheat sheet is ur reference, only basic syntax for now:
		//https://www.markdownguide.org/cheat-sheet/

		heading_1 = Pattern.compile( "^(#)\\s{1}(\\w)+" );
		heading_2 = Pattern.compile( "^(##)\\s{1}(\\w)+" );
		heading_3 = Pattern.compile( "^(###)\\s{1}(\\w)+" );
		bold = Pattern.compile( "^(\\*\\*){1}(.*)(\\*\\*)${1}" );
		italic = Pattern.compile( "(\\*){1}(.*)(\\*)${1}" );
		blockquote = Pattern.compile( "^>\\s{1}.*" );
		ordered_list = Pattern.compile( "(-\\s{1}.*\\n)+" );
		unordered_list = Pattern.compile( "(\\d\\.)\\s{1}" );
		code = Pattern.compile( "`(.*)`" );
		horizontal_rule = Pattern.compile( "(---|***|___){1}" );
		link = Pattern.compile( "\\[\\w\\]\\(^https?:\\/\\/.*\\)" ); 
		image = Pattern.compile( "!\\[[\\w\\s]\\]\\(\\w(.jpg)$" );

		//throw compiled patterns into array (useful for later)
		patterns = new Pattern[] { heading_1, heading_2, heading_3, bold, italic, 
			blockquote, ordered_list, unordered_list, code, horizontal_rule, link, image };

		//HTMLdocument stuff to make empty html file
		p = new JEditorPane();
		p.setContentType("text/html");
		p.setText("..."); // Document text is provided below.
		htmldoc = (HTMLDocument) p.getDocument();
	}

	/**
	 * Method to scan .txt file w/ markdown -> construct .html file
	 */
	public File toHTML( Scanner scan )
	{
		//loop through document, scan line-by-line
		while ( scan.hasNext() )
		{
			String currentln = scan.nextLine();

			//loop through list of patterns, search for match
			for ( int i = 0; i < patterns.length; i++ )
			{
				//ignore empty lines (stop trying to pattern match the line)
				Matcher empty = emptyLn.matcher( currentln );
				if ( empty.matches() )
				{
					continue;
				}
				//check current pattern in list for match
				Matcher m = p[i].matcher( currentln );
				//TODO need to find way to store String attribute for tag
				if ( m.matches() )
				{
					switch ( i )
					{
						case 0:
							
							//htmldoc.insertAfterStart()

							break;
						case 1:

							break;
						case 2:

							break;
						case 3:

							break;
						case 4:

							break;
						case 5:

							break;
						case 6:

							break;
						case 7:

							break;
						case 8:

							break;
						case 9:

							break;
						case 10:

							break;
						case 11:

							break;
					}
					//TODO GENERATE THE HTML stuff for the DOCUMENT 4HEAD
				}
			}
		}
	}
}