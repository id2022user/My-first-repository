package NW.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 名
 * @date 2023/grade0/25grade2:36
 */
public class SkillView1 {
        private static Scanner scanner=new Scanner(System.in);
        private static List<Skill> skills=new ArrayList<>();

    public static int readSelection(int limit) {
        int input;
        while (true) {
            try {
                System.out.println("请输入选项：");
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请重新输入。");
                continue;
            }
            if (input <1 || input > limit) {
                System.out.println("输入超出范围，请重新输入。");
                continue;
            }
            return input;


        }
    }
    public static int readSkill(int limit) {
        int input;
        while (true) {
            try {
                System.out.println("请输入技能选项（输入-1返回上一页）：");
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请重新输入。");
                continue;
            }
            if (input <-1 || input >= limit) {
                System.out.println("输入超出范围，请重新输入。");
                continue;
            }
            return input;


        }
    }
    static {

        skills.add(new Skill("[火球]",0,5,20,0,1,false));
        skills.add(new Skill("[土遁]",0,7,0,20,1,false));
        skills.add(new Skill("[疗伤术]",10,5,0,0,1,false));

        skills.add(new Skill("[旋风]",0,12,35,0,5,false));
        skills.add(new Skill("[暗黑之盾]",0,20,0,50,5,false));
        skills.add(new Skill("[水之涟漪]",20,15,0,0,5,false));

        skills.add(new Skill("[闪电五连鞭]",0,32,65,0,10,false));
        skills.add(new Skill("[木网]",0,28,0,70,10,false));
        skills.add(new Skill("[森林之歌]",50,40,0,0,10,false));

        skills.add(new Skill("[奇魂]",0,50,80,0,15,false));
        skills.add(new Skill("[地狱之火]",0,40,80,0,15,false));
        skills.add(new Skill("[圣盾]",0,45,0,100,15,false));
    }
    public static void openSkillView(){
        while (true){
            System.out.println("===============================================");
            System.out.println("\u001b[33m1.技能学习界面\u001b[0m");
            System.out.println("\u001b[33m2.技能使用界面\u001b[0m");
            System.out.println("3.返回上一界面");
            System.out.println("===============================================");
            int chose=readSelection(3);
            switch (chose){
                case 1:
                    studySkill();
                    break;
                case 2:
                    useSkill();
                    break;
                case 3:

                    return;
            }
        }

    }
    public static void studySkill(){
        while (true){
            System.out.println("===============================================");
            System.out.println("\u001b[4;36;40m\t技能\t\t\t\t   是否已学习\t\t需要等级\u001b[0m");
            System.out.println();
            for (int i = 0; i < skills.size(); i++) {
                String formatName=String.format("%-"+20+"s",skills.get(i).getName());
                if(skills.get(i).isStudy()){
                    System.out.printf("%d:\t\u001b[35m%-20s\u001b[0m\t%s\t\t%-2d%s",i,skills.get(i).getName(),"是",skills.get(i).getGrade(),"级");
                }else {
                    System.out.printf("%d:\t\u001b[35m%-20s\u001b[0m\t%s\t\t%-2d%s",i,skills.get(i).getName(),"\u001b[31m否\u001b[0m",skills.get(i).getGrade(),"级");
                }
                System.out.println();
            }
            System.out.println("===============================================");
            int chose=readSkill(skills.size());
            if(chose==-1)return;
            if(Player.grade<skills.get(chose).getGrade()){
                System.out.println("你的等级不够，学习失败");
            }else {
                if(skills.get(chose).isStudy()){
                    System.out.println(skills.get(chose).getName()+" 已学习过了");
                }else {
                    skills.get(chose).setStudy(true);
                    System.out.println(skills.get(chose).getName()+"学习成功");

                }
            }


        }
    }
    public static void useSkill(){
        while (true){
            System.out.println("===============================================");
            for (int i = 0; i < skills.size(); i++) {
                if(skills.get(i).isStudy()){
                    System.out.printf("%-2d:\u001b[35m%-17s\u001b[0m\tHP+%-5d\u001b[31mMP-%-5d\u001b[0mATK+%-5dDFE+%-5d",i,skills.get(i).getName(),skills.get(i).getHp(),skills.get(i).getMp(),skills.get(i).getAtk(),skills.get(i).getDfe());
                    System.out.println();
                }else {
                    System.out.printf("%-2d:\u001b[35m%-17s\u001b[0m\t%s",i,skills.get(i).getName(),"\u001b[31m未学习\u001b[0m");
                    System.out.println();
                }
            }
            System.out.println("===============================================");
            int chose=readSkill(skills.size());
            if(chose==-1)return;
            if(!skills.get(chose).isStudy()){
                System.out.println("技能未学习");
            }else {
                if(Player.mp<skills.get(chose).getMp()){
                    System.out.println("蓝不够");
                }
                else {
                    skills.get(chose).set();
                    System.out.println("技能使用成功");
                    System.out.printf("HP:%d MP:%d ATK:%d DFE:%d",Player.hp,Player.mp,Player.atk,Player.dfe);
                    System.out.println();
                }
            }

        }

    }
}
