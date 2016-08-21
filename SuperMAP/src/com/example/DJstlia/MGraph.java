package com.example.DJstlia;

public class MGraph {
	
	int UNDEFINE = 32767;
	
	
	int vexs[] = new int[20];   //记录各个顶点
	int arcs[][] = new int[30][30];  //用于存储邻接矩阵
	int vexnum,arcnum;   //  顶点数    弧数
	
	//初始化数据   将节点信息   矩阵信息全部初始化
	public MGraph() {
		
		this.vexnum = 17;
		this.arcnum = 18;
		
		//为节点添加数值代表
		for (int i = 0; i < 17; i++) {
			vexs[i] = i+1;
		}
		
		//将矩阵中自己跟自己的点距离设为0   不相连的点距离设为最大
		for (int i = 0; i < vexnum; i++) {
			for (int j = 0; j < vexnum; j++) {
				
				if(i==j)
				{arcs[i][j]=0;}
				else
					arcs[i][j]=UNDEFINE;
			}	
		}
		
		//为每一条边赋值
		arcs[0][1] = arcs[1][0] = 80;
		arcs[0][3] = arcs[3][0] = 107;
		arcs[3][2] = arcs[2][3] = 34;
		arcs[1][2] = arcs[2][1] = 32;
		arcs[3][6] = arcs[6][3] = 51;
		arcs[6][7] = arcs[7][6] = 65;
		arcs[7][8] = arcs[8][7] = 49;
		arcs[8][9] = arcs[9][8] = 48;
		arcs[8][5] = arcs[5][8] = 70;
		arcs[5][4] = arcs[4][5] = 64;
		arcs[4][1] = arcs[1][4] = 109;
		arcs[4][12] = arcs[12][4] = 269;
		arcs[12][13] = arcs[13][12] = 46;
		arcs[13][14] = arcs[14][13] = 32;
		arcs[14][15] = arcs[15][14] = 33;
		arcs[9][10] = arcs[10][9] = 69;
		arcs[10][11] = arcs[11][10] = 68;
		arcs[11][16] = arcs[16][11] = 200;
	}

	public int getUNDEFINE() {
		return UNDEFINE;
	}

	public void setUNDEFINE(int uNDEFINE) {
		UNDEFINE = uNDEFINE;
	}

	public int[] getVexs() {
		return vexs;
	}

	public void setVexs(int[] vexs) {
		this.vexs = vexs;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public void setArcs(int[][] arcs) {
		this.arcs = arcs;
	}

	public int getVexnum() {
		return vexnum;
	}

	public void setVexnum(int vexnum) {
		this.vexnum = vexnum;
	}

	public int getArcnum() {
		return arcnum;
	}

	public void setArcnum(int arcnum) {
		this.arcnum = arcnum;
	}
	
}
