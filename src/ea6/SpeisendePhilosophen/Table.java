package ea6.SpeisendePhilosophen;

public class Table {
    Philosoph[] philosophs;
    ChopStick[] chopSticks;

    public Table(int numberOfSeats) {
        chopSticks = new ChopStick[numberOfSeats];
        philosophs = new Philosoph[numberOfSeats];
        for (int i = 0; i < numberOfSeats; i++) {
            chopSticks[i] = new ChopStick();
        }
        for (int iPhilosoph = 0; iPhilosoph < numberOfSeats; iPhilosoph++) {
            int iLeftStick = (iPhilosoph + 1) % numberOfSeats;
            int iRightStick = iPhilosoph;
            philosophs[iPhilosoph] = new Philosoph("Philosoph " + iPhilosoph, chopSticks[iLeftStick], chopSticks[iRightStick]);
            philosophs[iPhilosoph].start();
        }
    }



    public static void main(String[] args) {
        new Table(5);
    }
}

