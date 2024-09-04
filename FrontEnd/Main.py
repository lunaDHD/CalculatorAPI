# Example file showing a basic pygame "game loop"
import pygame
import time
import requests
import json
import base64
from tkinter import *
from tkinter import messagebox
Tk().wm_withdraw()

# pygame setup
pygame.init()
modes = pygame.display.list_modes()
screen = pygame.display.set_mode(modes[0], pygame.FULLSCREEN)
running = True
global Answer
Answer = 'Welcome!'
global Equation
Equation = ''
global Buttonregistrationkeys
Buttonregistrationkeys = []
global Buttonregistrationvalues
Buttonregistrationvalues = []
helpscreenon = 0

button_colors = [(250, 30, 220), (150,60,130)]
BG_colors = [(0, 255, 255), (0,255,0)]
Help_colors = [(255, 0, 0), (255, 255, 0)]
def Draw_Button(x, y, w, h, Button_Collor, txt='1', txtsize = 30, appenditem=''):
    global Equation
    num_gradient_steps = int(h)  # Number of steps in the gradient
    gradient_step = 1 / num_gradient_steps
            
    for i in range(num_gradient_steps):
        color = tuple(int(Button_Collor[0][c] * (1 - gradient_step * i) + Button_Collor[1][c] * gradient_step * i) for c in range(3))
        pygame.draw.rect(screen, color, (int(x), i + int(y), int(w), 1))
        font = pygame.font.Font(None, txtsize)
        text = font.render(txt, True, 'Black')
        text_rect = text.get_rect(center=(x + w/2, y + h/2), width = w, height = h)
        screen.blit(text, text_rect)
        if not text_rect in Buttonregistrationkeys:
            Buttonregistrationvalues.append(appenditem)
            Buttonregistrationkeys.append(text_rect)

screenw,screenh = screen.get_size()

def DrawDefaults():
    Draw_Button(0, 0, screenw, screenh, BG_colors, '')
    Draw_Button(screenw/12*4,screenh/9*2,screenw/13,screenh/10, button_colors, 'AC', appenditem='AC')
    Draw_Button(screenw/12*5,screenh/9*2,screenw/13,screenh/10, button_colors, 'Neg', appenditem='➖')
    Draw_Button(screenw/12*6,screenh/9*2,screenw/13,screenh/10, button_colors, '?', appenditem='Help')
    Draw_Button(screenw/12*7,screenh/9*2,screenw/12,screenh/10, button_colors, '/', appenditem=' / ')
    Draw_Button(screenw/12*4,screenh/9*3,screenw/13,screenh/10, button_colors, '7', appenditem='7')
    Draw_Button(screenw/12*5,screenh/9*3,screenw/13,screenh/10, button_colors, '8', appenditem='8')
    Draw_Button(screenw/12*6,screenh/9*3,screenw/13,screenh/10, button_colors, '9', appenditem='9')
    Draw_Button(screenw/12*7,screenh/9*3,screenw/12,screenh/10, button_colors, '*', appenditem=' * ')
    Draw_Button(screenw/12*4,screenh/9*4,screenw/13,screenh/10, button_colors, '4', appenditem='4')
    Draw_Button(screenw/12*5,screenh/9*4,screenw/13,screenh/10, button_colors, '5', appenditem='5')
    Draw_Button(screenw/12*6,screenh/9*4,screenw/13,screenh/10, button_colors, '6', appenditem='6')
    Draw_Button(screenw/12*7,screenh/9*4,screenw/12,screenh/10, button_colors, '-', appenditem=' - ')
    Draw_Button(screenw/12*4,screenh/9*5,screenw/13,screenh/10, button_colors, '1', appenditem='1')
    Draw_Button(screenw/12*5,screenh/9*5,screenw/13,screenh/10, button_colors, '2', appenditem='2')
    Draw_Button(screenw/12*6,screenh/9*5,screenw/13,screenh/10, button_colors, '3', appenditem='3')
    Draw_Button(screenw/12*7,screenh/9*5,screenw/12,screenh/10, button_colors, '+', appenditem=' + ')
    Draw_Button(screenw/12*4,screenh/9*6,screenw/12 + screenw/13,screenh/10, button_colors, '0', appenditem='0')
    Draw_Button(screenw/12*6,screenh/9*6,screenw/13,screenh/10, button_colors, '.', appenditem='.')
    Draw_Button(screenw/12*7,screenh/9*6,screenw/12,screenh/10, button_colors, '=', appenditem='exec')
DrawDefaults()

while running:
    # poll for events
    # pygame.QUIT event means the user clicked X to close your window
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        if event.type == pygame.MOUSEBUTTONUP:
            pos = pygame.mouse.get_pos()
            if helpscreenon == False:
                for button in Buttonregistrationkeys:
                    if button.collidepoint(pos):
                        appenditem = Buttonregistrationvalues[Buttonregistrationkeys.index(button)]
                        if appenditem == 'AC':
                            Equation = ''
                            Answer = ''
                        elif appenditem == 'Help':
                            messagebox.showinfo('Help Menu','Help Menu')
                        elif appenditem == 'exec':
                            thingy = base64.b64encode(bytes(Equation, "utf8"))
                            thingy = str(thingy).lstrip('b\'').rstrip('\'')
                            r = requests.get(f'http://localhost:8080/calculate?string64={thingy}')
                            r = r.json()
                            print(r)
                            Answer = str(r['answer'])
                            Equation = ''
                        else:
                            Equation += appenditem
        if event.type == pygame.WINDOWMAXIMIZED:
            DrawDefaults()
        if event.type == pygame.WINDOWENTER:
            DrawDefaults()
    

    if Equation == '':
        bigtxt = Answer
    else:
        bigtxt = Equation.replace('➖', '-')
    
    Draw_Button(screenw/12*4,screenh/9,screenw/12*4,screenh/10, button_colors, bigtxt)
    
    # flip() the display to put your work on screen
    pygame.display.flip()

    time.sleep(1/60)

    

pygame.quit()