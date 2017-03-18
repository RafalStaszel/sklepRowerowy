

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Copyright (c) 2016, Taksila LLC. All rights reserved.
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * <p>
 * - Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * <p>
 * - Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * <p>
 * - Neither the name of Taksila LLC or the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * <p>
 * Created by Taksila LLC on 12/12/2016.
 */
public class LoanTableModel extends AbstractTableModel {

    ArrayList<Object[]> tabledata;
    String[] header;

    public LoanTableModel( Object[][] data, String[] header ) {
        this.header = header;
        tabledata = new ArrayList<Object[]>();
        if( data == null ) {
            return;
        }
        for( int count = 0; count < data.length; count++ ) {
            tabledata.add( data[count] );
        }
    }

    public int getRowCount() {
        int size = 0;
        if( tabledata != null ) {
            size = tabledata.size();
        }
        return size;
    }

    public int getColumnCount() {
        int size = 0;
        if( header != null ) {
            size = header.length;
        }
        return size;
    }

    public Object getValueAt( int rowindex, int colindex) {
        return tabledata.get( rowindex )[colindex];
    }

    public String getColumnName( int index ) {
        return header[index];
    }

    public void add( Object[] data ) {
        tabledata.add( data );
        fireTableDataChanged();
    }

    public void add( int month, double beginningBalance, double interest,
                     double installment, double principalAmt, double endingBalance ) {
        Object[] data = new Object[6];
        data[0] = new Integer( month );
        data[1] = new Double( beginningBalance );
        data[2] = new Double( interest );
        data[3] = new Double( installment );
        data[4] = new Double( principalAmt );
        data[5] = new Double( endingBalance );
        add( data );
    }

    public void remove( int rowindex ) {
        tabledata.remove( rowindex );
        fireTableRowsDeleted( rowindex,rowindex );
    }

    public void removeAll() {
        int rowCount = tabledata.size();
        tabledata.clear();
        fireTableRowsDeleted( 0, rowCount-1);
    }
}
