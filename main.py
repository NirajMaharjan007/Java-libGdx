import pygame as pg
from sys import exit


pg.init()
screen_width = 800
screen_height = 600
screen = pg.display.set_mode((screen_width, screen_height))
pg.display.set_caption("My Pygame Screen")


def render():
    running = True

    while running:
        for event in pg.event.get():
            if event.type == pg.QUIT:
                running = False

        # Fill the screen with a color (in this case, white)
        screen.fill((255, 255, 255))

        # Update the display
        pg.display.flip()


def main():
    render()
    pg.quit()
    exit()


if __name__ == '__main__':
    main()
