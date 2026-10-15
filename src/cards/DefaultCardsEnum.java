package cards;

public enum DefaultCardsEnum {
  LEAF_A("./resources/default_card_sprites/leaf_a.png", 0, 11),
  LEAF_2("./resources/default_card_sprites/leaf_2.png", 1, 2),
  LEAF_3("./resources/default_card_sprites/leaf_3.png", 2, 3),
  LEAF_4("./resources/default_card_sprites/leaf_4.png", 3, 4),
  LEAF_5("./resources/default_card_sprites/leaf_5.png", 4, 5),
  LEAF_6("./resources/default_card_sprites/leaf_6.png", 5, 6),
  LEAF_7("./resources/default_card_sprites/leaf_7.png", 6, 7),
  LEAF_8("./resources/default_card_sprites/leaf_8.png", 7, 8),
  LEAF_9("./resources/default_card_sprites/leaf_9.png", 8, 9),
  LEAF_J("./resources/default_card_sprites/leaf_j.png", 9, 10),
  LEAF_Q("./resources/default_card_sprites/leaf_q.png", 10, 10),
  LEAF_K("./resources/default_card_sprites/leaf_k.png", 11, 10),

  SPADE_A("./resources/default_card_sprites/spade_a.png", 12, 11),
  SPADE_2("./resources/default_card_sprites/spade_2.png", 13, 2),
  SPADE_3("./resources/default_card_sprites/spade_3.png", 14, 3),
  SPADE_4("./resources/default_card_sprites/spade_4.png", 15, 4),
  SPADE_5("./resources/default_card_sprites/spade_5.png", 16, 5),
  SPADE_6("./resources/default_card_sprites/spade_6.png", 17, 6),
  SPADE_7("./resources/default_card_sprites/spade_7.png", 18, 7),
  SPADE_8("./resources/default_card_sprites/spade_8.png", 19, 8),
  SPADE_9("./resources/default_card_sprites/spade_9.png", 20, 9),
  SPADE_J("./resources/default_card_sprites/spade_j.png", 21, 10),
  SPADE_Q("./resources/default_card_sprites/spade_q.png", 22, 10),
  SPADE_K("./resources/default_card_sprites/spade_k.png", 23, 10),

  HEART_A("./resources/default_card_sprites/heart_a.png", 24, 11),
  HEART_2("./resources/default_card_sprites/heart_2.png", 25, 2),
  HEART_3("./resources/default_card_sprites/heart_3.png", 26, 3),
  HEART_4("./resources/default_card_sprites/heart_4.png", 27, 4),
  HEART_5("./resources/default_card_sprites/heart_5.png", 28, 5),
  HEART_6("./resources/default_card_sprites/heart_6.png", 29, 6),
  HEART_7("./resources/default_card_sprites/heart_7.png", 30, 7),
  HEART_8("./resources/default_card_sprites/heart_8.png", 31, 8),
  HEART_9("./resources/default_card_sprites/heart_9.png", 32, 9),
  HEART_J("./resources/default_card_sprites/heart_j.png", 33, 10),
  HEART_Q("./resources/default_card_sprites/heart_q.png", 34, 10),
  HEART_K("./resources/default_card_sprites/heart_k.png", 35, 10),

  DIAMOND_A("./resources/default_card_sprites/diamond_a.png", 36, 11),
  DIAMOND_2("./resources/default_card_sprites/diamond_2.png", 37, 2),
  DIAMOND_3("./resources/default_card_sprites/diamond_3.png", 38, 3),
  DIAMOND_4("./resources/default_card_sprites/diamond_4.png", 39, 4),
  DIAMOND_5("./resources/default_card_sprites/diamond_5.png", 40, 5),
  DIAMOND_6("./resources/default_card_sprites/diamond_6.png", 41, 6),
  DIAMOND_7("./resources/default_card_sprites/diamond_7.png", 42, 7),
  DIAMOND_8("./resources/default_card_sprites/diamond_8.png", 43, 8),
  DIAMOND_9("./resources/default_card_sprites/diamond_9.png", 44, 9),
  DIAMOND_J("./resources/default_card_sprites/diamond_j.png", 45, 10),
  DIAMOND_Q("./resources/default_card_sprites/diamond_q.png", 46, 10),
  DIAMOND_K("./resources/default_card_sprites/diamond_k.png", 47, 10);

  private final String path;
  public final int id;
  public final int value;
  DefaultCardsEnum(String path, int id, int value) {
    this.path = path;
    this.id = id;
    this.value = value;

  }

  public String getPath() {
    return path;
  }
  public static DefaultCardsEnum getSprite(int id) {
    for (DefaultCardsEnum s : DefaultCardsEnum.values()) {
      if (s.id == id) {
        return s;
      }
    }
    return null;
  }
}
