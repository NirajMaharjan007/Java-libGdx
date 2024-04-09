import sys
import pygame as pg

from pygame.locals import *  # type: ignore

from OpenGL.GL import *  # type: ignore

from misc.collision import Collision
from misc.entity import *

WIDTH, HEIGHT = 800, 600
screen = pg.display.set_mode((WIDTH, HEIGHT), vsync=1, DOUBLEBUF | OPENGL)
pg.init()
pg.display.set_caption("Python Game")

player = Player(screen)
box = Box(screen)
pillar = Pillar(screen)
collision = Collision(pillar, player)


def set():
    clock = pg.time.Clock()
    clock.tick(60)
    screen.fill((255, 255, 255))

    Collision.entity_touch(box, player)

    if collision.collide():
        collision.player_touch()

    pillar.render()
    box.render()
    player.render()

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

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
    sys.exit(0)


if __name__ == "__main__":
    main()
