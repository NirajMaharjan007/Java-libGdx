from abc import ABC, abstractmethod

import numpy as np
import pygame as pg


class Entity(ABC):
    x = 32
    y = 32
    dir_x = 4
    dir_y = 8

    gravity = True

    def _gravity(self):
        if self.gravity:
            # self.x += self.dir_x
            self.y += self.dir_y * 1.2

    @abstractmethod
    def __init__(self, screen: pg.Surface):
        self.screen = screen

    @abstractmethod
    def render(self):
        pass


class Piller(Entity):
    def __init__(self, screen: pg.Surface):
        pass

    def render(self):
        super().render()


class Player(Entity):
    SIZE = 32

    color = (0, 255, 200)

    def __init__(self, screen: pg.Surface):
        super().__init__(screen)
        self.screen = screen

    def render(self):
        self._gravity()
        self.__move()
        self.__collision()

        pg.draw.rect(
            self.screen, self.color, pg.Rect(self.x, self.y, self.SIZE, self.SIZE)
        )

    def __collision(self):
        width = self.screen.get_width()
        height = self.screen.get_height()

        if self.x >= width:
            self.x = -self.SIZE - width

        if self.x <= 0:
            self.x = 0

        if self.y >= height - self.SIZE:
            self.y = height - self.SIZE

        if self.y <= 0:
            self.y = 0

    def __move(self):
        key = pg.key.get_pressed()
        self.gravity = True

        self.x += self.dir_x

        if key[pg.K_UP]:
            self.gravity = False
            self.y -= self.dir_y * 3.2

        if key[pg.K_RIGHT]:
            self.x += self.dir_x * 2

        # print(self.gravity)


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
            self.screen, self.color, pg.Rect(self.x, self.y, self.SIZE, self.SIZE)
        )

    def __move(self):
        width = self.screen.get_width()
        height = self.screen.get_height()

        self.x += self.dir_x
        self.y += self.dir_y

        if self.x >= width - self.SIZE or self.x <= 0:
            self.dir_x = -self.dir_x

        if self.y >= height - self.SIZE or self.y <= 0:
            self.dir_y = -self.dir_y

    # def follow(self, player: Player):
    # if self.x == player.x and self.y == player.y:
    #     self.x = player.x + self.SIZE
    #     self.y = player.y
