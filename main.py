import pygame as pg

from misc.collision import Collision
from misc.entity import *

WIDTH, HEIGHT = 800, 600
screen = pg.display.set_mode((WIDTH, HEIGHT), vsync=1)
pg.init()
pg.display.set_caption("Python Game")

player = Player(screen)
box = Box(screen)
collision = Collision(box, player)


def set():
    clock = pg.time.Clock()
    clock.tick(60)
    screen.fill((255, 255, 255))

    collision.collide()

    box.render()
    player.render()

    pg.display.flip()
    pg.display.update()


def main():
    run = True

    while run:
        for event in pg.event.get():
            if event.type == pg.QUIT:
                print("quit")
                run = False

        set()
        
    pg.quit()


if __name__ == "__main__":
    main()
