from abc import ABC, abstractmethod

import pygame as pg


class Entity(ABC):
    x = 32
    y = 32
    dir_x = 4
    dir_y = 8
    width = 16
    height = 16

    gravity = True

    def _gravity(self):
        if self.gravity:
            # self.x += self.dir_x
            self.y += self.dir_y * 1.6

    @abstractmethod
    def __init__(self, screen: pg.Surface):
        self.screen = screen

    @abstractmethod
    def render(self):
        pass


class Pillar(Entity):
    color = (128, 100, 100)

    def __init__(self, screen: pg.Surface):
        super(Pillar, self).__init__(screen)
        self.screen = screen
        self.height = 50
        self.width = self.screen.get_width()
        self.x = 0
        self.y = self.screen.get_height() - self.height

    def render(self):
        super().render()
        pg.draw.rect(
            self.screen, self.color, pg.Rect(self.x, self.y, self.width, self.height)
        )


class Player(Entity):
    color = (0, 255, 200)

    def __init__(self, screen: pg.Surface):
        super().__init__(screen)
        self.screen = screen
        self.width = self.height = 32

        self.jump = False
        self.count = 0.00

    def render(self):
        self._gravity()
        self.__move()
        self.__collision()

        pg.draw.rect(
            self.screen, self.color, pg.Rect(self.x, self.y, self.width, self.height)
        )

    def __collision(self):
        width = self.screen.get_width()
        height = self.screen.get_height()

        if self.x >= width:
            self.x = -self.width - width

        if self.x <= 0:
            self.x = 0

        if self.y >= height - self.height:
            self.y = height - self.height

        if self.y <= 0:
            self.y = 0

    def __move(self):
        key = pg.key.get_pressed()
        self.gravity = True

        for event in pg.event.get():
            if event.type == pg.KEYDOWN:
                if event.key == pg.K_UP and not self.jump:
                    self.jump = True
                    self.gravity = False

        if key[pg.K_RIGHT]:
            self.x += self.dir_x * 2

        if key[pg.K_LEFT]:
            self.x -= self.dir_x * 2

        """ if key[pg.K_UP] and not self.jump:
            self.gravity = False
            self.jump = True """

        print(self.count, self.jump)
        if self.jump:
            self.count += 0.50
            self.y -= self.dir_y * 4.20

            if self.count > 3.2:
                self.count = 0.00
                self.jump = False


class Box(Entity):
    # TODO: this is probably wrong
    """
    _summary_

    Args:
        Entity (_type_): _description_
        (っ◞‸◟ c)
    """
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
