import pygame as pg

from misc.entity import Entity


class Collision:
    def __init__(self, box: Entity, player: Entity):
        self.box = box
        self.player = player

    def collide(self) -> bool:
        box_rect = pg.Rect(self.box.x, self.box.y, 800, 46)

        player_rect = pg.Rect(
            self.player.x, self.player.y, self.player.SIZE, self.player.SIZE
        )

        return player_rect.colliderect(box_rect)

    def player_touch(self) -> None:
        print("player_touch")
