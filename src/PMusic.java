import java.util.ArrayList;

public class PMusic {

    public static void main(String[] args) {

        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:15,WORLD,CDEFGAB"};
        String m = "ABCDEFG";
        m = m.replaceAll("C#","l")
                .replaceAll("D#","m")
                .replaceAll("F#","n")
                .replaceAll("G#","o")
                .replaceAll("A#","p")
                .replaceAll("E#","q");
        ArrayList<String> musicList = new ArrayList<>();
        int index =0;

        for (String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            String sTime = music[0];
            String eTime = music[1];
            String title = music[2];
            String key = music[3];
            key= key.replaceAll("C#","l")
                    .replaceAll("D#","m")
                    .replaceAll("F#","n")
                    .replaceAll("G#","o")
                    .replaceAll("A#","p")
                    .replaceAll("E#","q");
            int sTimeHour;
            int sTimeMinute;
            int eTimeHour;
            int eTimeMinute;

            ArrayList<String> keyString = new ArrayList<>();
            ArrayList<String> fullKey = new ArrayList<>();
            int timeHour;
            int timeMinute;

            if (sTime.length()==4){
                sTimeHour = Integer.parseInt(sTime.substring(0, 1));
                sTimeMinute = Integer.parseInt(sTime.substring(2, 4));
                eTimeHour = Integer.parseInt(eTime.substring(0, 1));
                eTimeMinute = Integer.parseInt(eTime.substring(2, 4));
            }
            else {
                sTimeHour = Integer.parseInt(sTime.substring(0, 2));
                sTimeMinute = Integer.parseInt(sTime.substring(3, 5));
                eTimeHour = Integer.parseInt(eTime.substring(0, 2));
                eTimeMinute = Integer.parseInt(eTime.substring(3, 5));
            }
            if (sTimeMinute - eTimeMinute < 0) {
                timeHour = eTimeHour - 1 - sTimeHour;
                timeMinute = eTimeMinute + 60 - sTimeMinute;
            } else {
                timeHour = eTimeHour - sTimeHour;
                timeMinute = eTimeMinute - sTimeMinute;
            }

            int time = (timeHour * 60) + timeMinute;
            for (int i = 0; i < time; i++) {
                keyString.add(Character.toString(key.charAt(i % key.length())));
            }

            String temp = String.join("", keyString);
            temp = temp.replaceAll("C#","l")
                    .replaceAll("D#","m")
                    .replaceAll("F#","n")
                    .replaceAll("G#","o")
                    .replaceAll("A#","p")
                    .replaceAll("E#","q");

            fullKey.add(temp);

            System.out.println(fullKey);

            for (String full : fullKey) {
                if (full.contains(m)) {
                    musicList.add(musicinfo);
                }
            }
        }

        for (int i =0; i<musicList.size()-1;i++){

            int sTimeHour;
            int sTimeMinute;
            int eTimeHour;
            int eTimeMinute;
            int time;
            int sTime;
            int fTime;

            String[] first = musicList.get(i).split(",");
            String[] second = musicList.get(i+1).split(",");

            if (first[0].length()==4){
                sTimeHour = Integer.parseInt(first[0].substring(0, 1));
                sTimeMinute = Integer.parseInt(first[0].substring(2, 4));
                eTimeHour = Integer.parseInt(first[1].substring(0, 1));
                eTimeMinute = Integer.parseInt(first[1].substring(2, 4));
            }
            else {
                sTimeHour = Integer.parseInt(first[0].substring(0, 2));
                sTimeMinute = Integer.parseInt(first[0].substring(3, 5));
                eTimeHour = Integer.parseInt(first[1].substring(0, 2));
                eTimeMinute = Integer.parseInt(first[1].substring(3, 5));
            }
            fTime=eTimeHour*60+eTimeMinute-sTimeHour*60-sTimeMinute;

            if (second[0].length()==4){
                sTimeHour = Integer.parseInt(second[0].substring(0, 1));
                sTimeMinute = Integer.parseInt(second[0].substring(2, 4));
                eTimeHour = Integer.parseInt(second[1].substring(0, 1));
                eTimeMinute = Integer.parseInt(second[1].substring(2, 4));
            }
            else {
                sTimeHour = Integer.parseInt(second[0].substring(0, 2));
                sTimeMinute = Integer.parseInt(second[0].substring(3, 5));
                eTimeHour = Integer.parseInt(second[1].substring(0, 2));
                eTimeMinute = Integer.parseInt(second[1].substring(3, 5));
            }
            sTime = eTimeHour*60+eTimeMinute-sTimeHour*60-sTimeMinute;

            time = fTime-sTime;

            if (time<0){
                index = i+1;
            }


        }
        if(musicList.size()==0){
            System.out.println("none");

        }
        else {
            String[] answer = musicList.get(index).split(",");
            System.out.println(answer[2]);
        }
    }
}
