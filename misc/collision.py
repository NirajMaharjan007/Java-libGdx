import pygame as pg

from misc.entity import Entity


class Collision:
    def __init__(self, box: Entity, player: Entity):
        self.box = box
        self.player = player

    @staticmethod
    def entity_touch(box: Entity, player: Entity) -> None:
        box_rect = pg.Rect(box.x, box.y, box.width, box.height)

        player_rect = pg.Rect(player.x, player.y, player.width, player.height)

        if box_rect.colliderect(player_rect):
            box.dir_x = -box.dir_x

        # if (box_rect.x < player_rect.x+player_rect.width
        #         and box_rect.x+box_rect.width > player_rect.x):
            # box.dir_x = 0

    def collide(self) -> bool:
        box_rect = pg.Rect(self.box.x, self.box.y,
                           self.box.width, self.box.height)

        player_rect = pg.Rect(
            self.player.x, self.player.y,
            self.player.width, self.player.height
        )

        # print(box_rect, player_rect)

        return player_rect.colliderect(box_rect)

    def player_touch(self) -> None:
        if self.player.y >= self.box.y - self.box.height:
            # self.player.y = self.box.y - self.box.height
            self.player.gravity = False

        else:
            self.player.gravity = True
