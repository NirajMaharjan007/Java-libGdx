import pygame
import sys

# Initialize Pygame
pygame.init()

# Set up the display
width, height = 400, 400
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Follow on Collision (All Axes)")

# Colors
white = (255, 255, 255)
red = (255, 0, 0)

# Rectangle properties
rect1_width, rect1_height = 30, 30
rect2_width, rect2_height = 30, 30

# Initial positions
rect1_x, rect1_y = 50, 50
rect2_x, rect2_y = 200, 200

# Initial velocities
rect1_dx, rect1_dy = 2, 2
rect2_dx, rect2_dy = 1, 1

# Clock for controlling the frame rate
clock = pygame.time.Clock()

running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Clear the screen
    screen.fill(white)

    # Update rect1's position
    rect1_x += rect1_dx
    rect1_y += rect1_dy

    # Update rect2's position
    rect2_x += rect2_dx
    rect2_y += rect2_dy

    # Check for collisions
    rect1_rect = pygame.Rect(rect1_x, rect1_y, rect1_width, rect1_height)
    rect2_rect = pygame.Rect(rect2_x, rect2_y, rect2_width, rect2_height)

    if rect1_rect.colliderect(rect2_rect):
        # Rectangles are colliding, adjust their velocities to follow each other
        rect1_dx, rect1_dy = (rect2_x - rect1_x) / 10, (rect2_y - rect1_y) / 10
        rect2_dx, rect2_dy = -rect1_dx, -rect1_dy

    # Draw rect1 (red)
    pygame.draw.rect(screen, red, (rect1_x, rect1_y,
                     rect1_width, rect1_height))

    # Draw rect2 (green)
    pygame.draw.rect(screen, (0, 255, 0),
                     (rect2_x, rect2_y, rect2_width, rect2_height))

    pygame.display.flip()

    # Control the frame rate
    clock.tick(60)

pygame.quit()
sys.exit()
