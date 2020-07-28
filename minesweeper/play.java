import pkg.*;
public class play 
//implements InputControl, InputKeyControl 
{
		public static Rectangle temp;
		public static Rectangle[][] graph;
		public static int[][] gameM;
		public static int bomb;
		public play()
        {
			boolean contains=true;
		
			// following line is necessary for onMouseClick, don't change
			//MouseController mC = new MouseController(Canvas.getInstance(),new starter());
			
			// please leave following line alone, necessary for keyboard input
			//KeyController kC = new KeyController(Canvas.getInstance(),new starter());
			// put code here.
			EasyReader input1 = new EasyReader();
			System.out.print("Choose Level 1,2,3: ");
			int level = input1.readInt();
			System.out.println();
			minesweeper game = new minesweeper(level);
			gameM =game.displayMatrix();
			int[] zero= game.randomZero(); 
			//print(gameM);
			bomb=game.BOMB;
			graph = new Rectangle[gameM.length][gameM[0].length];
			System.out.println(zero[0]+" " +zero[1]);
			int x=100;
			int y=100;
			int legth=0;
			int numcont=0;
			for(int r=0;r<gameM.length;r++)
			{
				
				for(int c=0;c<gameM[0].length;c++)
				{
					
					
					graph[r][c]=new Rectangle(x,y,20,20);

					graph[r][c].setColor(Color.BLACK);
					graph[r][c].draw();
					Text t = new Text(x,y,numcont+"");
					t.draw();
					        
					
					x=x+20;
					
					legth++;
					numcont++;
				
				}
			x=x-(20*legth);
			legth=0;
			y=y+20;
			
			}

			Rectangle zeror = new Rectangle(graph[zero[0]][zero[1]].getX(), graph[zero[0]][zero[1]].getY(), 20,20);
			zeror.setColor(Color.YELLOW);
			zeror.fill();
			Text b = new Text(zeror.getX(),zeror.getY(),(gameM[zero[0]][zero[1]]+""));
			b.draw();
			
			while(contains)
			{
				boolean[][] win = new boolean[gameM.length][gameM[0].length];
				for(int r=0;r<gameM.length;r++)
				{
					
					for(int c=0;c<gameM[0].length;c++)
					{
						win[r][c]=false;
						
						
					}
				}
				int win1=0;
				EasyReader input = new EasyReader();
				System.out.print("input a square: ");
				String in = input.readLine();
				
				int user;
				int rownum=0;
				int colnum=0;
				boolean fl = true;
				//boolean 
				try
				{
					if((in.substring(in.length()-1, in.length())).equals("f"))
					{
						user =  Integer.parseInt(in.substring(0,in.length()-1));
						rownum=user/gameM[0].length;
						colnum =user%gameM[0].length;
						Rectangle w = new Rectangle(graph[rownum][colnum].getX(), graph[rownum][colnum].getY(), 20,20);
						w.setColor(Color.BLUE);
						w.fill();
						bomb --;
						fl=false;
					}
					else
					{
						user=Integer.parseInt(in);
						rownum=user/gameM[0].length;
						colnum =user%gameM[0].length;
						Rectangle w = new Rectangle(graph[rownum][colnum].getX(), graph[rownum][colnum].getY(), 20,20);
						w.setColor(Color.YELLOW);
						w.fill();
						Text p = new Text(w.getX(),w.getY(),(gameM[rownum][colnum]+""));
						p.draw();
						
					}
					System.out.println();
					if(gameM[rownum][colnum]==9&&fl)
					{
						Rectangle v = new Rectangle(graph[rownum][colnum].getX(), graph[rownum][colnum].getY(), 20,20);
						v.setColor(Color.RED);
						v.fill();
						System.out.print("Game Over");
						contains=false;
						
						
					}
					if(win[rownum][colnum])
					{
							win1--;
					}
					win[rownum][colnum]=true;
					win1++;
					
					
					
				}
				catch(Exception e)
				{
					System.out.println("Enter another value");
					
					
				}
				Rectangle bombr= new Rectangle(120,80,60,20);
				bombr.setColor(Color.WHITE);
				bombr.fill();
				Text bombt = new Text(120,80,"Flags: "+bomb);
				bombt.draw();
			
				System.out.println();
				
				if(win1==gameM.length*gameM[0].length)
					System.out.print("You Win");
				
				
				
			}
			
		}
		public static void print(int[][] a)
		{
			for(int r=0;r<a.length;r++)
			{
				
				for(int c=0;c<a[0].length;c++)
				{
					System.out.print(a[r][c]+" ");
			
				}
				
				System.out.println();
			}
			
			
			
	
		}
		

}





