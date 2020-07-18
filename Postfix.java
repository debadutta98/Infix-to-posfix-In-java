import java.util.*;
import java.io.*;
class Postfix
{
	static Stack<String> ob;
	public static void push_into_operator(String t)
	{

		if(ob==null)
		{
			ob=new Stack<String>();
			ob.push(t);
		}
		else
		{
			if(!ob.isEmpty())
			{
				if(t.equals("+") || t.equals("-"))
				{
					if(ob.peek().equals("-") || ob.peek().equals("+") || ob.peek().equals("*") || ob.peek().equals("/")|| ob.peek().equals("^"))
					{
						System.out.print(ob.pop());
						if(!ob.isEmpty()){
						if(ob.peek().equals("-") || ob.peek().equals("+") || ob.peek().equals("*") || ob.peek().equals("/")|| ob.peek().equals("^"))
						{
							push_into_operator(t);
							//ob.push(t);
						}
						if(ob.peek().equals(t))
						{return;}
						else
						{
							ob.push(t);
						}
						}
						else
						{
						ob.push(t);
						}
					}
					else
					{
						ob.push(t);
					}
				}
				else if(t.equals("*") || t.equals("/"))
				{
					if(ob.peek().equals("*") || ob.peek().equals("/")|| ob.peek().equals("^"))
					{
						System.out.print(ob.pop());
						if(!ob.isEmpty()){
						if(ob.peek().equals("*") || ob.peek().equals("/")|| ob.peek().equals("^"))
						{
							push_into_operator(t);
						}
						if(ob.peek().equals(t))
												{return;}
												else
												{
													ob.push(t);
						}
					}
						else{
						ob.push(t);
				        	}
					}
					else
					{
						ob.push(t);
					}
				}
				else if(t.equals("^"))
				{
					ob.push(t);
				}
				else if(t.equals("(") || t.equals("[") || t.equals("{"))
				{
					ob.push(t);
				}
			}

			else
			{
				ob.push(t);
			}
		}
	}
	public static void infix_to_postfix(String s)
	{
		ob=new Stack<String>();
		String s1="";
		for(int i=0;i<s.length();i++)
		{
			//System.out.println(ob);
			if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'||s.charAt(i)=='^')
			{
				String s3=String.valueOf(s.charAt(i));
				push_into_operator(s3);
			}
			else if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
			{
				String s3=String.valueOf(s.charAt(i));
				push_into_operator(s3);
			}
			else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}')
			{

					if(s.charAt(i)==')')
					{
						try{
							while(!ob.isEmpty())
							{
								if(ob.peek().equals("("))
								{
								ob.pop();
								break;
								}
								else
								{
									System.out.print(ob.pop());
								}
							}
						}
						catch(Exception e)
						{
							System.out.println("the express that you enter is wrong");
							return;
						}
					}
					else if(s.charAt(i)==']')
										{
											try{
												while(!ob.isEmpty())
																			{
																				if(ob.peek().equals("["))
																				{ob.pop();break;}
																				else
																				{System.out.print(ob.pop());}
							}
											}
											catch(Exception e)
											{
												System.out.println("the express that you enter is wrong");
												return;
											}
					}
					else{
						try{
													while(!ob.isEmpty())
																				{
																					if(ob.peek().equals("{")){ob.pop();
																					break;}
																					else
																					{System.out.print(ob.pop());}
							}
												}
												catch(Exception e)
												{
													System.out.println("the express that you enter is wrong");
													return;
						}
					}

			}
			else
			{
				System.out.print(s.charAt(i));
			}
		}

	}
	public static void main(String args[])
	{
		Stack<String> s=new Stack<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of testcases you want to test");
		int t=sc.nextInt();
     String s1;
		while(t-->0)
		{
		 s1=sc.next();
			infix_to_postfix(s1);
			if(ob.isEmpty())
			{
				ob=null;
			}
			else
			{
				while(!ob.isEmpty())
				{
					String r=ob.pop();
					//System.out.print(r);
					if(r.equals("(")||r.equals("[")||r.equals("{")||r.equals(")")||r.equals("]")||r.equals("}"))
					{
						ob.pop();
						System.out.println("it is not balanced please check!!");
						break;
					}
					else
					{
						System.out.print(r);
					}
				}
				//ob.pop();
				//System.out.println("it is not balanced please check!!");
				//ob=null;
				System.out.println();
			}
		}
	}
}