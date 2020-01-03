package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class PointIsInOrOut {
	public class Point{
		public double x;
		public double y;
		public Point(double x,double y) {
			this.x=x;
			this.y=y;
		}
	}
	public static String isInside(Point p,List<Point> list) {
		int j=list.size()-1;
		double px=p.x;
		double py=p.y;
		boolean flag=false;
		for (int i = 0; i < list.size(); j=i, i++) {
			double sx=list.get(i).x;
			double sy=list.get(i).y;
			double tx=list.get(j).x;
			double ty=list.get(j).y;
			
			if((px==sx && py==sy) ||(px==tx && py==ty)) {
				return "on";
			}
			
			//判断从p点出发，平行于x轴的射线是否与点（sx，sy）到点（tx，ty）的线段st相交
			if((sy>=py && py>ty) ||(ty>=py && py>sy)) {
				//(sx-tx)/(sy-ty)=(sx-x)/(sy-py)
				//求出交点的横坐标，交点为（x，py）
				double x=sx-(sy-py)*(sx-tx)/(sy-ty);	
				
				if(x==px) {
					return "on";
				}
				if(x>px) {
					flag=!flag;
				}
			
			}
		}
		return flag ? "in" : "out";
	}
	public static void main(String[] args) {
		Point p=new PointIsInOrOut().new Point(1.0, 2.4);
		List<Point> list = new ArrayList<Point>();
		
		list.add(new PointIsInOrOut().new Point(1.0, 2.0));
		list.add(new PointIsInOrOut().new Point(2.0, 3.0));
		list.add(new PointIsInOrOut().new Point(1.0, 1.0));
		list.add(new PointIsInOrOut().new Point(3.0, 5.0));
		list.add(new PointIsInOrOut().new Point(3.0, 2.0));
		
		System.out.println(isInside(p, list));
		
	}
}
