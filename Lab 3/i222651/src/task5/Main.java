package task5;

public class Main
{
	public static void main(String[] args)
	{
		_HashMap hashMap = new _HashMap();
		
		hashMap.Add("Sumeed", 0);
		hashMap.Add("Rafay", 4);
		hashMap.Add("Huzaifa", 2);
		hashMap.Add("Ubaid", 3);
		
		hashMap.Display();
		
		hashMap.Remove("Sumeed");
		hashMap.Remove("Bilal");
		
		hashMap.Display();
	}
}
