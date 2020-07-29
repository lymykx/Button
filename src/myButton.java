import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class myButton extends JFrame {
    public static void main(String[] args) {

        new myButton();
    }

    public myButton(){
        String resPath ="C:\\Windows\\System32\\drivers\\etc";
        String testPath ="C:\\Windows\\System32\\drivers\\etc\\测试环境";
        String checkPath ="C:\\Windows\\System32\\drivers\\etc\\验收环境";
        String proPath ="C:\\Windows\\System32\\drivers\\etc\\生产环境";
        String fileNa ="hosts";

        JButton buTest =new JButton("测试");
        buTest.setLayout(new GridLayout(1,2));
        JButton buCheck = new JButton("验收");
        buCheck.setLayout(new GridLayout(2,2));
        JButton buPro = new JButton("生产");
        buPro.setLayout(new GridLayout(3,2));

        buTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    copyFile(fileNa,resPath,testPath);
                    JOptionPane.showMessageDialog(null,"已切换测试环境~");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Ops...出错啦~~");
                    JOptionPane.showMessageDialog(null,"请你再点一次~~");
                }
                //System.out.println("成功切换测试huanjing");
            }
        });

        buCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    copyFile(fileNa,resPath,checkPath);
                    JOptionPane.showMessageDialog(null,"已切换验收环境~");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Ops...出错啦~~");
                    JOptionPane.showMessageDialog(null,"请你再点一次~~");
                }
                //System.out.println("成功切换验收");
            }
        });

        buPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    copyFile(fileNa,resPath,proPath);
                    JOptionPane.showMessageDialog(null,"已切换生产环境~");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Ops...出错啦~~");
                    JOptionPane.showMessageDialog(null,"请你再点一次~~");
                }
                //System.out.println("成功切换生产");
            }
        });
        add(buTest);
        add(buCheck);
        add(buPro);

        setLayout(new FlowLayout(1));
        setSize(300,200);
        setLocationRelativeTo(null);

        setTitle("ClickClick~");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private static void copyFile(String fileName,String newPath,String oldPath) throws IOException {
        File oldpaths = new File(oldPath + "/" + fileName);
        File newpaths = new File(newPath + "/" + fileName);
        if (!newpaths.exists()) {
            Files.copy(oldpaths.toPath(), newpaths.toPath());
        } else {
            newpaths.delete();
            Files.copy(oldpaths.toPath(), newpaths.toPath());
        }
    }
}
