package onlineShop.core;

public enum ComputerType implements CharSequence {
    Laptop,
    DesktopComputer;


    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
