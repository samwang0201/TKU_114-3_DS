public class PlaylistSystem {

    public static void main(String[] args) {

        PlaylistLinkedList playlist = new PlaylistLinkedList();

        System.out.println("===== 空白播放清單 =====");
        playlist.printPlaylist();

        System.out.println("\n===== 新增歌曲 =====");
        playlist.addLast("S001", "末班車");
        playlist.addLast("S002", "你是我的眼");
        playlist.addLast("S003", "阿嬤的話");
        playlist.addLast("S004", "上水的花");

        playlist.addLast("S002", "重複歌曲");

        System.out.println("\n===== 完整播放順序 =====");
        playlist.printPlaylist();

        System.out.println("\n===== 搜尋歌曲 =====");

        PlaylistNode foundSong = playlist.searchByCode("S003");

        if (foundSong != null) {
            System.out.println(
                    "找到歌曲：" + foundSong.songCode
                            + " - " + foundSong.songName);
        } else {
            System.out.println("找不到歌曲！");
        }

        foundSong = playlist.searchByCode("S999");

        if (foundSong != null) {
            System.out.println(
                    "找到歌曲：" + foundSong.songCode
                            + " - " + foundSong.songName);
        } else {
            System.out.println("找不到歌曲代碼：S999");
        }

        System.out.println("\n===== 刪除第一首 =====");
        playlist.removeByCode("S001");
        playlist.printPlaylist();

        System.out.println("\n===== 刪除最後一首 =====");
        playlist.removeByCode("S004");
        playlist.printPlaylist();

        System.out.println("\n===== 刪除不存在的歌曲 =====");
        playlist.removeByCode("S999");

        System.out.println("\n===== 最後播放順序 =====");
        playlist.printPlaylist();
    }
}