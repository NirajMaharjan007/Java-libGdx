import pygame as pg

from misc.entity import Entity


class Collision:
    def __init__(self, box: Entity, player: Entity):
        self.box = box
        self.player = player

    def collide(self) -> bool:
        box_rect = pg.Rect(self.box.x, self.box.y,
                           self.box.width, self.box.height)

        player_rect = pg.Rect(
            self.player.x, self.player.y, self.player.width, self.player.height
        )

        print(box_rect, player_rect)

        return player_rect.colliderect(box_rect)

    def player_touch(self) -> None:
        if self.player.y >= self.box.y - self.box.height:
            print("player_touch")
            # self.player.y = self.box.y - self.box.height
            self.player.gravity = False

        else:
            self.player.gravity = True
