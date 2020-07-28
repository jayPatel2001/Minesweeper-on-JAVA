import pkg.*;

	public class minesweeper 
	{
		int[][] a;
		int ranR;
		int ranC;
		int[][] matrix;
		int BOMB;
		public minesweeper(int level)
		{
			if(level==1)
				a =constrMatrix(10,7,10);
			
			
			
			if(level==2)
				a=constrMatrix(16,12,35);
			
			
			if(level==3)
				a=constrMatrix(22,16,75);
			
			
		}
		
		public int[][] constrMatrix(int row, int col, int bomb)
		{
			BOMB=bomb;
			matrix = new int[row][col];
			
			for(int c=0; c<bomb;c++)
			{
				int one = ((int)(Math.random()*row));
				int two = ((int)(Math.random()*col));
				//System.out.println(one+ " , " +two);
				if(matrix[one][two]==9)
				{
					c--;
				}
			
				else
					matrix[one][two]=9;
				
			
			}
			for(int r=0;r<row;r++)
			{
				for(int c=0;c<col;c++)
				{
					if(matrix[r][c]!=9)
					{
						matrix[r][c]= scan(matrix, r,c,row,col);
						if(matrix[r][c]==0)
						{
							ranR=r;
							ranC=c;
						}
					}
				
				
				
				}
			
			
			}
			
			return matrix;
		
		}
		
		private int scan(int[][] a,int r,int c,int row, int col)
		{
			int counter=0;
			for(int r1=r-1;r1<r+2;r1++)
			{
				for(int c1=c-1;c1<c+2;c1++)
				{
					
					if((r1<row)&&(c1<col)&&(r1>=0)&&(c1>=0)&&(matrix[r1][c1]==9))
					{
						counter++;
					}
				
				}
			
			
			}
			
			return counter;
		}


		public int[][] displayMatrix()
		{
			return a;
		}
		public int[] randomZero()
		{
			int[] temp = new int[2];
			temp[0]= ranR;
			temp[1]= ranC;
			return temp;
		
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