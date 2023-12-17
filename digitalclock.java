import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel dayLabel;

    public DigitalClock() {
        initializeUI();
        startClock();
    }

    private void initializeUI() {
        setTitle("Digital Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(350, 200));
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 70));

        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        dayLabel = new JLabel("", SwingConstants.CENTER);
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        mainPanel.add(timeLabel, BorderLayout.CENTER);
        mainPanel.add(dateLabel, BorderLayout.NORTH);
        mainPanel.add(dayLabel, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startClock() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        }, 0, 1000);
    }

    private void updateTime() {
        SwingUtilities.invokeLater(() -> {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");

            Date now = new Date();

            timeLabel.setText(timeFormat.format(now));
            dateLabel.setText(dateFormat.format(now));
            dayLabel.setText(dayFormat.format(now));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}