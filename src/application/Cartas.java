package application;

public class Cartas {
	
	    private int val;
	    private boolean vis;
	    private boolean bloq;
	    

		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public boolean isVis() {
			return vis;
		}
		public void setVis(boolean vis) {
			this.vis = vis;
		}
		public boolean isBloq() {
			return bloq;
		}
		public void setBloq(boolean bloq) {
			this.bloq = bloq;
		}
			
	public static Cartas [] carta =  new Cartas[8];
	public void  comparar () {
		
        for (int i = 0; i < carta.length; i++) {
            carta[i] = new Cartas();
            carta[i].setVal(0);
            carta[i].setVis(true);
            carta[i].setBloq(false);
        }
		
	}


}
