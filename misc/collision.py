import pygame as pg

from misc.entity import Box, Player


class Collision:
    def __init__(self, box: Box, player: Player):
        self.box = box
        self.player = player

    def collide(self):
        box_rect = pg.Rect(self.box.x, self.box.y,
                           self.box.SIZE, self.box.SIZE)

        player_rect = pg.Rect(self.player.x, self.player.y,
                              self.player.SIZE, self.player.SIZE)

        if player_rect.colliderect(box_rect):
            print("Oh no!..\tIt collide")
            
