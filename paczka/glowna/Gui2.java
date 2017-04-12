package paczka.glowna;






import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Gui2 extends JFrame{

    JTextField loanAmountFld;
    JTextField loanTermFld;
    JRadioButton loanTermMonthFld;
    JRadioButton loanTermYearFld;
    ButtonGroup loanTermUnitGrp;
    JTextField interestRateFld;
    LoanTableModel tableModel;
    JTable table;

    public static void main( String[] args ) {
        /*LoanInstallmentCalcApp multApp = new LoanInstallmentCalcApp();
        multApp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        centreWindow( multApp );
        multApp.setVisible(true);*/

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                Gui2 multApp = new Gui2();
                multApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                centreWindow( multApp );
                multApp.setVisible(true);
            }
        });
    }

    public Gui2() {
        this.setTitle( "Sklep Rowerowy Magazyn");
        this.setSize( 800, 600 );
        initializeGUI();
    }

    private void initializeGUI() {
    //    addWindowListener( new ConfirmOnClose() );
        JPanel content = (JPanel)this.getContentPane();
        content.setLayout( new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0;    //0th column
        c.gridy = 0;    //oth Row
        c.gridwidth = 4;  // Title spans four columns
        JLabel label = new JLabel( "Magazyn rowerowy", SwingConstants.CENTER );
        content.add( label,c );

    /*    c.gridx = 0;    //0th column
        c.gridy = 1;    //1st Row
        c.gridwidth = 4;  // Title spans two columns
        JLabel subLabel = new JLabel( "Use this calculator to compute the payment amount (principal and interest) for a fixed rate loan.", SwingConstants.CENTER );
        content.add( subLabel,c );*/


       /* c.gridx = 0;    //0th Column
        c.gridy = 4;    //4th Row
        c.gridwidth = 1;
        label = new JLabel( "Loan Amount", SwingConstants.LEFT );
        content.add( label, c );*/

    /*    c.gridx = 1;    //1st column
        c.gridy = 4;    //4th Row
        c.gridwidth = 1;
        loanAmountFld = new JTextField( "20000", 4);
        content.add( loanAmountFld, c );

        c.gridx = 0;    //0th Column
        c.gridy = 5;    //5th Row
        c.gridwidth = 1;
        label = new JLabel( "Loan Term", SwingConstants.LEFT );
        content.add( label, c );

        c.gridx = 1;    //1st column
        c.gridy = 5;    //5th Row
        c.gridwidth = 1;
        loanTermFld = new JTextField( "5", 4);
        content.add( loanTermFld, c );

        c.gridx = 2;    //2nd Column
        c.gridy = 5;    //5th Row
        c.gridwidth = 1;
        loanTermMonthFld = new JRadioButton( "Months" );
        loanTermYearFld = new JRadioButton( "Years" );
        loanTermUnitGrp = new ButtonGroup();
        loanTermUnitGrp.add( loanTermMonthFld );
        loanTermUnitGrp.add( loanTermYearFld );
        loanTermYearFld.setSelected( true );
        content.add( loanTermMonthFld, c );
        c.gridx = 3;    //3rd Column
        c.gridy = 5;    //5th Row
        c.gridwidth = 1;
        content.add( loanTermYearFld, c );

        c.gridx = 0;    //0th Column
        c.gridy = 6;    //6th Row
        c.gridwidth = 1;
        label = new JLabel( "Interest Rate in Percentage", SwingConstants.LEFT );
        content.add( label, c );

        c.gridx = 1;    //1st column
        c.gridy = 6;    //6th Row
        c.gridwidth = 1;
        interestRateFld = new JTextField( "8.00", 4);
        content.add( interestRateFld, c );*/

        c.gridx = 0;    //0th Column
        c.gridy = 8;    //1st Row
        c.gridwidth = 2;
        JButton button = new JButton( "Poka¿ rowery" );
        button.setActionCommand( "pokaz" );
     //   button.addActionListener( new ButtonActions() );
        content.add( button, c );

      /*  c.gridx = 1;    //1st Row
        c.gridy = 2;    //1st Column
*/

       c.gridx = 0;
       c.gridy = 10;
      c.gridwidth = 4;
        JPanel tablepanel = getTableLoanPymtPanel();
       content.add( tablepanel, c );



    }

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

   

 

    private JPanel getTableLoanPymtPanel() {
        JPanel tablepanel = new JPanel( new BorderLayout() );
        String[] header = { "LP", "Marka", "Model", "Rozmiar", "Cena zakupu", "Cena sprzeda¿y" };
        Object[][] data = new Object[10][6];
        tableModel = new LoanTableModel( data, header );
        table = new JTable( tableModel );
        tablepanel.add( new JScrollPane(table));

        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth( 50 );
        colModel.getColumn(1).setPreferredWidth( 150 );
        colModel.getColumn(2).setPreferredWidth( 100);
        colModel.getColumn(3).setPreferredWidth( 100 );
        colModel.getColumn(4).setPreferredWidth( 150 );
        colModel.getColumn(5).setPreferredWidth( 150 );
        table.getColumnModel().getColumn(1).getCellRenderer( );
        table.getColumnModel().getColumn(2).getCellRenderer( );
        table.getColumnModel().getColumn(3).getCellRenderer( );
        table.getColumnModel().getColumn(4).getCellRenderer(  );
        table.getColumnModel().getColumn(5).getCellRenderer( );
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        return tablepanel;
    }

}

