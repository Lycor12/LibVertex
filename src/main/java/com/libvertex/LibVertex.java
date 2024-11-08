package com.libvertex;

import com.libvertex.math.util.TimeHelper;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

/**
 * LibVertex is a utility class that provides functionality for initializing and managing
 * GLFW windows with OpenGL context, as well as basic methods such as window closing, game loops, etc..
 *
 * This class handles the basic setup required for creating a window and establishing
 * an OpenGL rendering context. It provides methods for initialization and cleanup.
 */
public class LibVertex {
    /** Flag indicating if the game loop is running */
    private boolean running = false;

    /** Target frames per second for the game loop */
    private int fps = 60;

    /**
     * Initializes GLFW and creates a window with OpenGL context.
     * This method performs the following operations:
     * - Initializes GLFW
     * - Creates a window with the specified dimensions and title
     * - Makes the OpenGL context current
     * - Creates OpenGL capabilities
     * - Enables vertical synchronization
     *
     * @param width  The width of the window in pixels
     * @param height The height of the window in pixels
     * @param title  The title of the window
     * @return The window handle
     * @throws IllegalStateException If GLFW initialization fails
     * @throws RuntimeException      If window creation fails
     */
    public static long init(int width, int height, String title) {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        long window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == MemoryUtil.NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLFW.glfwSwapInterval(1);

        return window;
    }

    /**
     * Closes the specified GLFW window and stops the game loop.
     *
     * @param window The handle of the window to close
     */
    public void closeWindow(long window) {
        running = false;
        GLFW.glfwSetWindowShouldClose(window, true);
    }

    /**
     * Starts and manages the main game loop.
     * The loop runs at the specified FPS and executes update and render logic.
     *
     * @param updateLogic The logic to run for updates
     * @param renderLogic The logic to run for rendering
     * @param window The handle of the window to use for the game loop
     */
    public void gameLoop(Runnable updateLogic, Runnable renderLogic, long window) {
        running = true;
        while (running && !GLFW.glfwWindowShouldClose(window)) {
            TimeHelper.update();

            updateLogic.run();
            renderLogic.run();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }

    /**
     * Sets a callback for window resize events.
     *
     * @param callback The callback to handle resize events
     * @param window The handle of the window to set the callback for
     */
    public void setWindowResizeCallback(WindowResizeCallback callback, long window) {
        GLFW.glfwSetWindowSizeCallback(window, (win, width, height) -> {
            callback.onResize(width, height);
        });
    }

    /**
     * Checks if a specific key is currently pressed.
     *
     * @param keyCode The GLFW key code to check
     * @param window The handle of the window to check input for
     * @return true if the key is pressed, false otherwise
     */
    public boolean isKeyPressed(int keyCode, long window) {
        return GLFW.glfwGetKey(window, keyCode) == GLFW.GLFW_PRESS;
    }

    /**
     * Sets a callback for window focus events.
     *
     * @param callback The callback to handle focus events
     * @param window The handle of the window to set the callback for
     */
    public void setFocusCallback(WindowFocusCallback callback, long window) {
        GLFW.glfwSetWindowFocusCallback(window, (win, focused) -> {
            callback.onFocusChange(focused);
        });
    }

    /**
     * Sets the target frames per second for the game loop.
     *
     * @param fps The desired frames per second
     */
    public void setFPS(int fps) {
        this.fps = fps;
    }

    /**
     * Centers the window on the primary monitor.
     *
     * @param window The handle of the window to center
     */
    public void centerWindow(long window) {
        long monitor = GLFW.glfwGetPrimaryMonitor();
        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(monitor);
        int[] width = new int[1];
        int[] height = new int[1];
        GLFW.glfwGetWindowSize(window, width, height);
        GLFW.glfwSetWindowPos(window,
                (videoMode.width() - width[0]) / 2,
                (videoMode.height() - height[0]) / 2
        );
    }

    /**
     * Interface for handling window resize events.
     */
    public interface WindowResizeCallback {
        /**
         * Called when the window is resized.
         *
         * @param width The new width of the window
         * @param height The new height of the window
         */
        void onResize(int width, int height);
    }

    /**
     * Interface for handling window focus events.
     */
    public interface WindowFocusCallback {
        /**
         * Called when the window focus changes.
         *
         * @param focused true if the window gained focus, false if it lost focus
         */
        void onFocusChange(boolean focused);
    }

    /**
     * Terminates GLFW and releases all resources.
     * This method should be called when the application is shutting down
     * to properly clean up GLFW resources.
     */
    public static void terminate() {
        GLFW.glfwTerminate();
    }
}