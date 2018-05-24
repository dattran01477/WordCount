package test1;
import java.awt.EventQueue;








import test1.WordCount;










import javax.swing.JFrame;
import javax.swing.JFileChooser;



import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;









import java.awt.event.ActionEvent;










import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;














import java.io.BufferedReader;
import java.io.File;




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionListener;


import java.awt.TextArea;









import javax.swing.BoxLayout;




import javax.swing.JList;

import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;










import javax.swing.filechooser.FileFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class test {

	private JFrame frmWordcount;

	private File[] selectedFile;
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmWordcount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
		deleteListFileInfolder("output");
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void DocFile(TextArea txtAKQ) throws IOException 
	{
		FileReader rd=new FileReader("output/part-r-00000");
		BufferedReader bfr=new BufferedReader(rd);
		String line="";
		while ((line=bfr.readLine())!=null)
		{
			txtAKQ.append(line+"\n");
		}
		rd.close();
		bfr.close();
	}


    public boolean deleteListFileInfolder(String source) {
        File folder = new File(source);
//        folder tồn tại
        if (folder.exists()) {
//            danh sách file 
            File[] listFile = folder.listFiles();
            if (listFile.length != 0) {
                for (File f : listFile) {
//                file thì xóa
                    if (f.isFile()) {
                        f.delete();
                    }
                }
            }
            folder.delete();
          System.out.println("Delete folder thành công!");
            return true;
        } else {
            System.out.println("folder không tồn tại");
            return false;
        }
    }

    public boolean deleteListFileInfolder1(String source) {
        File folder = new File(source);
//        folder tồn tại
        if (folder.exists()) {
//            danh sách file 
            File[] listFile = folder.listFiles();
            if (listFile.length != 0) {
                for (File f : listFile) {
//                file thì xóa
                    if (f.isFile()) {
                        f.delete();
                    }
                }
            }
            folder.delete();
          System.out.println("Delete folder thành công!");
            return true;
        } else {
            System.out.println("folder không tồn tại");
            return false;
        }
    }
	private void initialize() {
		frmWordcount = new JFrame();
		frmWordcount.getContentPane().setEnabled(false);
		frmWordcount.setAutoRequestFocus(false);
		frmWordcount.setTitle("WordCount");
		frmWordcount.setSize(650, 400);
		frmWordcount.getContentPane().setLayout(new BoxLayout(frmWordcount.getContentPane(), BoxLayout.X_AXIS));
		
		Panel panel = new Panel();
		frmWordcount.getContentPane().add(panel);
		
		final JList<File> lstDSFILE = new JList<File>();
		
		JLabel lblNewLabel = new JLabel("Danh Sách Các Tệp");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		final TextArea txtAKQ = new TextArea();
		
		JButton btnNewButton = new JButton("Kết Quả -->");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					WordCount.Dem(selectedFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					DocFile(txtAKQ);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnChnFile = new JButton("Chọn File");
		btnChnFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfile=new 	JFileChooser();
				jfile.setMultiSelectionEnabled(true);
				jfile.showOpenDialog(null);
				
				DefaultListModel<File> listModel = new DefaultListModel<File>();
				selectedFile = jfile.getSelectedFiles();
				
				for(int i=0;i<selectedFile.length;i++)
				{
					listModel.addElement(selectedFile[i].getAbsoluteFile());
				}
				lstDSFILE.setModel(listModel);
			}
		});
		btnChnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnChnFile))
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lstDSFILE, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnNewButton)
							.addGap(39)
							.addComponent(txtAKQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lstDSFILE, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtAKQ, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnChnFile)
					.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(167, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(161))
		);
		panel.setLayout(gl_panel);
	}
	  
}
