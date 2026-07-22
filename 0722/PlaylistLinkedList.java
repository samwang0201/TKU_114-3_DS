public class PlaylistLinkedList {

    private PlaylistNode head;

    public PlaylistLinkedList() {
        head = null;
    }

    public void addLast(String songCode, String songName) {

        if (searchByCode(songCode) != null) {
            System.out.println("歌曲代碼重複，新增失敗：" + songCode);
            return;
        }

        PlaylistNode newNode = new PlaylistNode(songCode, songName);

        if (head == null) {
            head = newNode;
            System.out.println("成功新增：" + songName);
            return;
        }

        PlaylistNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        System.out.println("成功新增：" + songName);
    }

    public PlaylistNode searchByCode(String songCode) {

        PlaylistNode current = head;

        while (current != null) {
            if (current.songCode.equals(songCode)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public void removeByCode(String songCode) {

        if (head == null) {
            System.out.println("播放清單是空的，無法刪除！");
            return;
        }

        if (head.songCode.equals(songCode)) {
            System.out.println("成功刪除：" + head.songName);
            head = head.next;
            return;
        }

        PlaylistNode current = head;

        while (current.next != null) {
            if (current.next.songCode.equals(songCode)) {
                System.out.println("成功刪除：" + current.next.songName);
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        System.out.println("找不到歌曲代碼：" + songCode);
    }

    public void printPlaylist() {

        if (head == null) {
            System.out.println("播放清單是空的！");
            return;
        }

        PlaylistNode current = head;
        int order = 1;

        while (current != null) {
            System.out.println(
                    order + ". " + current.songCode
                            + " - " + current.songName);

            current = current.next;
            order++;
        }
    }
}