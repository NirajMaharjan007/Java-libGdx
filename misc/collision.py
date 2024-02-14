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

        return player_rect.colliderect(box_rect)

            
    def player_touch(self):
        self.box.dir_x = -self.box.dir_x
        self.box.dir_y = -self.box.dir_y
        
    
            
