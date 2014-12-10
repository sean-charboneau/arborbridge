public class NumberWords
{
	public static void main(String[] args)
	{
		System.out.println(getEnglishName(9999999));
		System.out.println(getEnglishName(123456789));
		System.out.println(getEnglishName(0));
		System.out.println(getEnglishName(8465));
		System.out.println(getEnglishName(10101010));
		System.out.println(getEnglishName(-9999999));
		System.out.println(getEnglishName(1));
		System.out.println(getEnglishName(2013467895));
	}
	
	public static String getEnglishName(int n)
	{
		if (n == 0) return "zero";
		
		String[] places = {"thousand ", "million ", "billion "};
		int place = -1;
		String result = "";
		boolean negative = false;
		if (n < 0)
		{
			negative = true;
			n = Math.abs(n);
		}
		
		while(n > 0)
		{
			int chunk = n % 1000;
			String toAdd = getEnglishThousandsName(chunk);
			if (place > -1 && toAdd.length() > 0)
			{
				toAdd += " " + places[place];
			}
			place++;
			result = toAdd + result;
			n /= 1000;
		}
		
		if (negative)
		{
			result = "negative " + result;
		}
		
		return result;
	}
	
	// PRECONDITION: n < 1000
	public static String getEnglishThousandsName(int n)
	{
		String[] lowNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
							 "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] tensNames = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		
		if (n < 20) return lowNames[n];
		if (n < 100) return tensNames[n/10] + " " + lowNames[n%10];

		String result = lowNames[n/100] + " hundred";
		if ((n/10)%10 > 1) result += " " + tensNames[(n/10)%10];
		if (n%10 > 0) result += " " + lowNames[n%10];
		
		return result;
	}
}