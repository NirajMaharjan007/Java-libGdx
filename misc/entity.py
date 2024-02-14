import pygame as pg

import numpy as np


class Player:
    x = 16
    y = 16

    SIZE = 32
    SPEED = 4

    color = (0, 255, 200)

    def __init__(self, screen: pg.Surface):
        self.screen = screen

    def render(self):
        self.__move()
        self.__collision()

        pg.draw.rect(
            self.screen, self.color,
            pg.Rect(self.x, self.y, self.SIZE, self.SIZE)
        )

    def __collision(self):
        width = self.screen.get_width()
        height = self.screen.get_height()

        if self.x >= width - self.SIZE:
            self.x = width - self.SIZE

        if self.x <= 0:
            self.x = 0

        if self.y >= height - self.SIZE:
            self.y = height - self.SIZE

        if self.y <= 0:
            self.y = 0

    def __move(self):
        key = pg.key.get_pressed()

        if key[pg.K_DOWN]:
            self.y += self.SPEED

        if key[pg.K_UP]:
            self.y -= self.SPEED

        if key[pg.K_LEFT]:
            self.x -= self.SPEED

        if key[pg.K_RIGHT]:
            self.x += self.SPEED

        if key[pg.K_SPACE]:
            self.SPEED = 12

        else:
            self.SPEED = 4


class Box:
    x = y = 8
    SIZE = 32
    dir_x, dir_y = 6, 6
    color = (128, 0, 200)

    def __init__(self, screen: pg.Surface):
        self.screen = screen

    def render(self):
        # self.__collision()
        self.__move()
        pg.draw.rect(
            self.screen, self.color,
            pg.Rect(self.x, self.y, self.SIZE, self.SIZE)
        )

    def __move(self):
        width = self.screen.get_width()
        height = self.screen.get_height()

        self.x += self.dir_x
        self.y += self.dir_y

        if self.x >= width - self.SIZE or self.x <= 0:
            self.dir_x = - self.dir_x

        if self.y >= height - self.SIZE or self.y <= 0:
            self.dir_y = -self.dir_y

    # def follow(self, player: Player):
    # if self.x == player.x and self.y == player.y:
    #     self.x = player.x + self.SIZE
    #     self.y = player.y
