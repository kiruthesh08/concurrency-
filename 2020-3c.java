import java.util.Date;

public class Main  {
    private static UsbDrive usb1 = new UsbDrive();
    private static UsbDrive usb2 = new UsbDrive();

    public static void main(String[] args) throws  Exception  {
        Thread thread1 = new Thread(new ThreadA());
        Thread thread2 = new Thread(new ThreadB());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    static class ThreadA implements Runnable  {
        @Override
        public void run()  {
            synchronized (usb1) {
                usb1.cutAndPaste(usb2, 1, 2);
            }
        }
    }

    static class ThreadB implements Runnable  {
        @Override
        public void run()  {
            synchronized (usb2) {
                usb2.cutAndPaste(usb1, 1, 2);
            }
        }
    }
}

class UsbDrive extends HardDrive {
    private Date lastUpdate;

    private void updateDate()  {
        lastUpdate = new Date();
    }

    public synchronized void cutAndPaste(UsbDrive other, int originAddress, int destAddress)  {
        byte[] data = read(originAddress);

        try  {
            Thread.sleep(5000);
        }
        catch (Exception e)  {
            e.printStackTrace();
        }

        boolean success = other.write(data, destAddress);
        if (success) {
            erase(originAddress);
            updateDate();
        } else {
            throw new RuntimeException("Write failed!");
        }
    }
}

class HardDrive  {
    public synchronized byte[] read(int address)  {return new byte[]{};}
    public synchronized boolean write(byte[] data, int address)  {return true;}
    public synchronized void erase(int address)  {}
}
