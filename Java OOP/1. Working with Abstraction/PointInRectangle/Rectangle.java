package PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    public boolean contains(Point currentPont){
        boolean pointX = this.bottomLeft.getPointX() <= currentPont.getPointX() && this.topRight.getPointX() >= currentPont.getPointX();
        boolean pointY = this.bottomLeft.getPointY() <= currentPont.getPointY() && this.topRight.getPointY() >= currentPont.getPointY();
        if (pointX&&pointY){
            return true;
        }
        return false;
    }
}
