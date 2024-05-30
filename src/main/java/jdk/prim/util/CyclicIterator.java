/**
 * 
 */
package jdk.prim.util;

import java.util.Iterator;

/**
 * Defines an interface for cyclic iterators, which allows cyclic iteration over
 * a collection. It extends the standard Iterator interface and provides a
 * method to get the number of complete revolutions made during iteration. All
 * {@link CyclicIterator} instance must have at least one element, or their
 * behaviour will be undefined.
 * <p>
 * Example:
 * 
 * <pre>
 * <code>
 * List&lt;Integer&gt; numbers = Arrays.asList(1, 2, 3, 4, 5);
 * CyclicIterator&lt;Integer&gt; cyclicIterator = Iterators.c(numbers);
 * 
 * while (cyclicIterator.getRevolutions() &lt; 2) {
 *     System.out.println(cyclicIterator.next());
 * }
 * </code>
 * </pre>
 * 
 * In this example, the cyclic iterator iterates over the list of numbers twice.
 * The {@code getRevolutions()} method is used to ensure that the iteration
 * stops after completing two full cycles.
 * <p>
 * Another example:
 * 
 * <pre>
 * <code>
 * List&lt;String&gt; colors = Arrays.asList("Red", "Green", "Blue");
 * CyclicIterator&lt;String&gt; cyclicIterator = Iterators.c(colors);
 * 
 * for (int i = 0; i &lt; 5; i++) {
 *     System.out.println(cyclicIterator.next());
 * }
 * </code>
 * </pre>
 * 
 * In this example, the cyclic iterator iterates over the list of colors
 * repeatedly. Even though the list contains only three elements, the iterator
 * cycles through them indefinitely due to the cyclic nature of the iteration.
 * 
 * @implNote The use of {@link #nextXxx()} is preferred over the use of
 *           {@link #next()} because {@link #next()} is implemented by calling
 *           and casting {@link #nextXxx()}. This only refers to the nested
 *           sub-interfaces.
 * @implNote Default implementation does not support modification such as
 *           {@link #remove()}
 *
 * @param <T> the type of elements in the iterator
 */
public interface CyclicIterator<T> extends Iterator<T> {

	/**
	 * Interface for iterating over primitive {@code double} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code PrimitiveIterator.OfDouble} to
	 * provide cyclic iteration capabilities specifically for {@code double} values.
	 * 
	 * <p>
	 * <h4>Reason for existence:</h4> A real-world scenario where a cyclic iterator
	 * of double values might be useful is in simulating periodic or cyclical
	 * behavior, such as oscillations or waveforms in signal processing or
	 * simulation applications.
	 * <p>
	 * For example, consider a software application that simulates a physical system
	 * where a periodic signal needs to be generated, such as a sine wave
	 * representing sound waves or electrical signals. In such a scenario, you might
	 * need to iterate over a set of double or float values representing the
	 * amplitude of the waveform at each point in time. However, instead of just
	 * iterating once through the waveform, you may need to cyclically iterate over
	 * the waveform to simulate continuous or repetitive behavior.
	 * <p>
	 * <h4>Example:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // An array representing a sine wave
	 * double[] sineWave = {0.0, 0.5, 0.8, 1.0, 0.8, 0.5, 0.0, -0.5, -0.8, -1.0, -0.8, -0.5};
	 * 
	 * // Create a cyclic iterator for the sine wave
	 * CyclicIterator.OfDouble cyclicIterator = Iterators.c(sineWave);
	 * 
	 * // Simulate processing of the waveform for a certain duration
	 * long simulationDurationInMillis = 5000; // 5 seconds
	 * long startTime = System.currentTimeMillis();
	 * 
	 * while (System.currentTimeMillis() - startTime < simulationDurationInMillis) {
	 *     double amplitude = cyclicIterator.nextDouble();
	 *     
	 *     // Process the amplitude value, such as sending it to a speaker or performing calculations
	 *     // based on the waveform
	 *     
	 *     // Sleep for a short duration to simulate real-time processing
	 *     Thread.sleep(10); // Sleep for 10 milliseconds
	 * }
	 * </code>
	 * </pre>
	 * 
	 * In this example, the cyclic iterator is used to iterate over the sine wave
	 * values repeatedly for a simulated duration of 5 seconds. This could be part
	 * of a larger simulation or application where continuous or cyclic processing
	 * of waveforms is required, such as in audio synthesis, signal processing, or
	 * scientific simulations.
	 * 
	 * @implNote The use of {@link #nextDouble()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextDouble()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfDouble extends java.util.PrimitiveIterator.OfDouble, CyclicIterator<Double> {
	}

	/**
	 * Interface for iterating over primitive {@code long} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code PrimitiveIterator.OfLong} to
	 * provide cyclic iteration capabilities specifically for {@code long} values.
	 * 
	 * <p>
	 * Practical usage example of {@code CyclicIterator.OfLong} in cryptography and
	 * security. This example demonstrates how to use a cyclic iterator of long
	 * values to implement a circular buffer for cryptographic operations in a
	 * secure communication system.
	 * 
	 * <h4>Scenario:</h4>
	 * <p>
	 * In a secure communication system, cryptographic algorithms are applied to
	 * data streams to ensure confidentiality and integrity of the transmitted
	 * information. To perform cryptographic operations efficiently, a circular
	 * buffer is used to store and process data.
	 * </p>
	 * 
	 * <h4>Implementation:</h4>
	 * <p>
	 * We use a cyclic iterator of long values to represent the circular buffer. As
	 * data is received from the communication channel, it is added to the buffer,
	 * and the cyclic iterator is used to iterate over the buffer, applying
	 * cryptographic algorithms to the data in a continuous loop.
	 * </p>
	 * 
	 * <p>
	 * During each iteration of the cryptographic processing loop:
	 * </p>
	 * <ul>
	 * <li>We retrieve the next block of data from the cyclic iterator, representing
	 * the next segment in the circular buffer.</li>
	 * <li>We apply cryptographic algorithms (e.g., encryption, decryption, hashing)
	 * to the data block to ensure confidentiality and integrity of the transmitted
	 * information.</li>
	 * <li>We continue processing the data blocks until the end of the buffer is
	 * reached, at which point the iterator wraps around to the beginning of the
	 * buffer.</li>
	 * </ul>
	 * 
	 * <h4>Example Code:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a circular buffer with a capacity of 100 long values (data blocks)
	 * long[] circularBuffer = new long[100];
	 * 
	 * // Create a cyclic iterator for the circular buffer
	 * CyclicIterator.OfLong cyclicIterator = Iterators.c(circularBuffer);
	 * 
	 * // Simulate secure communication with cryptographic operations
	 * while (secureChannel.isOpen()) {
	 *     // Receive a block of data from the secure communication channel
	 *     long dataBlock = secureChannel.receiveData();
	 *     
	 *     // Add the received data block to the circular buffer
	 *     circularBuffer[cyclicIterator.getRevolutions()] = dataBlock;
	 *     
	 *     // Apply cryptographic algorithms to the data block from the circular buffer
	 *     long processedData = applyCryptographicOperations(cyclicIterator.nextLong());
	 *     
	 *     // Transmit the processed data over the secure communication channel
	 *     secureChannel.transmitData(processedData);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This practical usage demonstrates how {@code CyclicIterator.OfLong} can be
	 * used in cryptography and security applications to implement circular buffers
	 * for performing cryptographic operations efficiently in secure communication
	 * systems.
	 * </p>
	 * 
	 * @implNote The use of {@link #nextLong()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextLong()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfLong extends java.util.PrimitiveIterator.OfLong, CyclicIterator<Long> {
	}

	/**
	 * Interface for iterating over primitive {@code int} values in a cyclic manner.
	 * This interface is a purely primitive extension of {@code CyclicIterator} and
	 * extends {@code PrimitiveIterator.OfInt} to provide cyclic iteration
	 * capabilities specifically for {@code int} values.
	 * 
	 * <p>
	 * Practical usage example of {@code CyclicIterator.OfInt} in digital signal
	 * processing (DSP). This example demonstrates how to use a cyclic iterator of
	 * int values to implement a circular buffer for processing audio signals in a
	 * digital signal processing application.
	 * 
	 * <h4>Scenario:</h4>
	 * <p>
	 * In a digital signal processing (DSP) application for audio signals, we need
	 * to process a continuous stream of audio samples represented as 32-bit integer
	 * values. To efficiently process the audio data, we use a circular buffer to
	 * store the samples and apply various signal processing algorithms.
	 * </p>
	 * 
	 * <h4>Implementation:</h4>
	 * <p>
	 * We use a cyclic iterator of int values to represent the circular buffer for
	 * audio samples. As new audio samples arrive, they are added to the buffer, and
	 * the cyclic iterator is used to iterate over the buffer, processing the
	 * samples in a continuous loop.
	 * </p>
	 * 
	 * <p>
	 * During each iteration of the signal processing loop:
	 * </p>
	 * <ul>
	 * <li>We retrieve the next audio sample from the cyclic iterator, representing
	 * the next sample in the circular buffer.</li>
	 * <li>We apply various signal processing algorithms to the audio sample, such
	 * as filtering, modulation, or transformation.</li>
	 * <li>We continue processing the audio samples until the end of the buffer is
	 * reached, at which point the iterator wraps around to the beginning of the
	 * buffer.</li>
	 * </ul>
	 * 
	 * <h4>Example Code:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a circular buffer with a capacity of 1024 audio samples (32-bit integer values)
	 * int[] circularBuffer = new int[1024];
	 * 
	 * // Create a cyclic iterator for the circular buffer
	 * CyclicIterator.OfInt cyclicIterator = Iterators.c(circularBuffer);
	 * 
	 * // Simulate audio signal processing
	 * for (int i = 0; i < audioData.length; i++) {
	 *     // Read a 32-bit audio sample from the input data stream
	 *     int audioSample = audioData[i];
	 *     
	 *     // Add the audio sample to the circular buffer
	 *     circularBuffer[cyclicIterator.getRevolutions()] = audioSample;
	 *     
	 *     // Apply signal processing algorithms to the audio sample from the circular buffer
	 *     int processedSample = processAudioSample(cyclicIterator.nextInt());
	 *     
	 *     // Output or further process the processed audio sample
	 *     outputAudioSample(processedSample);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This practical usage demonstrates how {@code CyclicIterator.OfInt} can be
	 * used in digital signal processing (DSP) applications to implement circular
	 * buffers for efficiently processing audio signals.
	 * </p>
	 * 
	 * @implNote The use of {@link #nextInt()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextInt()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfInt extends java.util.PrimitiveIterator.OfInt, CyclicIterator<Integer> {
	}

	/**
	 * Interface for iterating over primitive {@code char} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code PrimitiveIterator.OfChar} to
	 * provide cyclic iteration capabilities specifically for {@code char} values.
	 * <p>
	 * <h4>Reason for existence:</h4> Cyclic iteration over primitive char values
	 * can be useful in scenarios such as cycling through characters in circular
	 * patterns or rotating character sequences.
	 * 
	 * <h4>Example:</h4>
	 * 
	 * <pre>
	 * <code>
	 * char[] symbols = {'*', '+', '-'};
	 * CyclicIterator.OfChar cyclicIterator = Iterators.c(symbols);
	 * 
	 * for (int i = 0; i < 5; i++) {
	 *     System.out.println(cyclicIterator.nextChar());
	 * }
	 * </code>
	 * </pre>
	 * 
	 * In this example, the cyclic iterator iterates over the char array five times,
	 * cycling through the symbols '*', '+', '-' repeatedly.
	 * 
	 * @implNote The use of {@link #nextChar()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextChar()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfChar extends PrimitiveIterator.OfChar, CyclicIterator<Character> {
	}

	/**
	 * Interface for iterating over primitive {@code float} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code Iterators.OfFloat} to provide
	 * cyclic iteration capabilities specifically for {@code float} values.
	 * <p>
	 * Practical usage example of {@code CyclicIterator.OfFloat} in gaming/data
	 * visualization. This example demonstrates how to use a cyclic iterator of
	 * float values to implement an animation system where objects move along a
	 * predefined circular path, such as a planet orbiting around a central point.
	 * 
	 * <h4>Scenario:</h4>
	 * <p>
	 * We have a 2D game scene with a sprite representing a planet orbiting around a
	 * central point. The objective is to animate the planet's movement along a
	 * circular path.
	 * </p>
	 * 
	 * <h4>Implementation:</h4>
	 * <p>
	 * We use a cyclic iterator of float values to represent the x and y coordinates
	 * of the planet as it orbits around the center. The orbit is defined by
	 * parameters such as the center coordinates, radius, and angular velocity.
	 * </p>
	 * 
	 * <p>
	 * During each iteration of the game loop or animation loop:
	 * </p>
	 * <ul>
	 * <li>We update the position of the planet by retrieving the next x and y
	 * coordinates from the cyclic iterators.</li>
	 * <li>We render the scene with the planet at its updated position.</li>
	 * <li>We control the frame rate to ensure smooth animation playback.</li>
	 * </ul>
	 * 
	 * <h4>Example Code:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Define parameters for the circular orbit
	 * float centerX = 300.0f; // X coordinate of the center of the orbit
	 * float centerY = 300.0f; // Y coordinate of the center of the orbit
	 * float radius = 200.0f; // Radius of the orbit
	 * float angularVelocity = 0.01f; // Angular velocity (radians per frame)
	 * 
	 * // Create cyclic iterators for x and y coordinates
	 * CyclicIterator.OfFloat cyclicX = createCircularIterator(centerX, radius, 0.0f, 2 * Math.PI, angularVelocity);
	 * CyclicIterator.OfFloat cyclicY = createCircularIterator(centerY, radius, 0.0f, 2 * Math.PI, angularVelocity);
	 * 
	 * // Game loop or animation loop
	 * while (true) {
	 *     // Update the position of the planet
	 *     float planetX = cyclicX.nextFloat();
	 *     float planetY = cyclicY.nextFloat();
	 *     
	 *     // Render the scene with the planet at its updated position
	 *     renderScene(planetX, planetY);
	 *     
	 *     // Sleep or delay to control the frame rate
	 *     // This ensures that the animation plays smoothly
	 *     try {
	 *         Thread.sleep(16); // Sleep for approximately 16 milliseconds (60 frames per second)
	 *     } catch (InterruptedException e) {
	 *         e.printStackTrace();
	 *     }
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This practical usage demonstrates how {@code CyclicIterator.OfFloat} can be
	 * employed in gaming or data visualization applications to create dynamic and
	 * visually appealing animations, such as objects moving along predefined
	 * circular paths or trajectories.
	 * </p>
	 * 
	 * @implNote The use of {@link #nextFloat()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextFloat()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfFloat extends PrimitiveIterator.OfFloat, CyclicIterator<Float> {
	}

	/**
	 * Interface for iterating over primitive {@code short} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code PrimitiveIterator.OfShort} to
	 * provide cyclic iteration capabilities specifically for {@code short} values.
	 * 
	 * <p>
	 * Practical usage example of {@code CyclicIterator.OfShort} in a Unicode
	 * transformation scenario. This example demonstrates how to use a cyclic
	 * iterator of short values to implement a circular buffer for transforming
	 * Unicode characters in a text processing application.
	 * 
	 * <h4>Scenario:</h4>
	 * <p>
	 * In a text processing application, we need to transform Unicode characters
	 * using a circular buffer to efficiently process the text data. Unicode
	 * characters are represented as 16-bit values (shorts), and we want to apply a
	 * transformation algorithm to each character in the text.
	 * </p>
	 * 
	 * <h4>Implementation:</h4>
	 * <p>
	 * We use a cyclic iterator of short values to represent the circular buffer. As
	 * Unicode characters are processed, their corresponding 16-bit values are added
	 * to the buffer. The cyclic iterator is then used to iterate over the buffer,
	 * applying the transformation algorithm to each character in a continuous loop.
	 * </p>
	 * 
	 * <p>
	 * During each iteration of the transformation loop:
	 * </p>
	 * <ul>
	 * <li>We retrieve the next Unicode character from the cyclic iterator,
	 * representing the next character in the circular buffer.</li>
	 * <li>We apply the transformation algorithm to the Unicode character,
	 * converting it into its transformed form.</li>
	 * <li>We continue processing the text data until the end of the buffer is
	 * reached, at which point the iterator wraps around to the beginning of the
	 * buffer.</li>
	 * </ul>
	 * 
	 * <h4>Example Code:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a circular buffer with a capacity of 100 shorts (Unicode characters)
	 * short[] circularBuffer = new short[100];
	 * 
	 * // Create a cyclic iterator for the circular buffer
	 * CyclicIterator.OfShort cyclicIterator = Iterators.c(circularBuffer);
	 * 
	 * // Simulate text processing with Unicode transformation
	 * for (int i = 0; i < text.length(); i++) {
	 *     // Read a Unicode character from the text
	 *     char unicodeChar = text.charAt(i);
	 *     
	 *     // Convert the Unicode character to its 16-bit value and add it to the circular buffer
	 *     short unicodeValue = (short) unicodeChar;
	 *     circularBuffer[cyclicIterator.getRevolutions()] = unicodeValue;
	 *     
	 *     // Apply the transformation algorithm to the Unicode character from the circular buffer
	 *     short transformedValue = transformUnicode(cyclicIterator.nextShort());
	 *     
	 *     // Convert the transformed 16-bit value back to a Unicode character and process it further
	 *     char transformedChar = (char) transformedValue;
	 *     processTransformedCharacter(transformedChar);
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This practical usage demonstrates how {@code CyclicIterator.OfShort} can be
	 * used in text processing applications to implement circular buffers for
	 * transforming Unicode characters efficiently.
	 * </p>
	 * 
	 * @implNote The use of {@link #nextShort()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextShort()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfShort extends PrimitiveIterator.OfShort, CyclicIterator<Short> {
	}

	/**
	 * Interface for iterating over primitive {@code byte} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code Iterators.OfByte} to provide cyclic
	 * iteration capabilities specifically for {@code byte} values.
	 * 
	 * <p>
	 * Practical usage example of {@code CyclicIterator.OfByte} in any programming
	 * scenario. This example demonstrates how to use a cyclic iterator of byte
	 * values to implement a circular buffer for streaming data processing.
	 * 
	 * <h4>Scenario:</h4>
	 * <p>
	 * In a data processing application, we need to process a continuous stream of
	 * byte data in a circular buffer. The circular buffer allows us to efficiently
	 * process the data by continuously looping over it.
	 * </p>
	 * 
	 * <h4>Implementation:</h4>
	 * <p>
	 * We use a cyclic iterator of byte values to represent the circular buffer. As
	 * new byte data arrives, it is added to the buffer, and the cyclic iterator is
	 * used to iterate over the buffer, processing the data in a continuous loop.
	 * </p>
	 * 
	 * <p>
	 * During each iteration of the processing loop:
	 * </p>
	 * <ul>
	 * <li>We retrieve the next byte from the cyclic iterator, representing the next
	 * byte in the circular buffer.</li>
	 * <li>We process the byte data, performing any required operations or
	 * calculations.</li>
	 * <li>We continue processing the data until the end of the buffer is reached,
	 * at which point the iterator wraps around to the beginning of the buffer.</li>
	 * </ul>
	 * 
	 * <h4>Example Code:</h4>
	 * 
	 * <pre>
	 * <code>
	 * // Create a circular buffer with a capacity of 10 bytes
	 * byte[] circularBuffer = new byte[10];
	 * 
	 * // Create a cyclic iterator for the circular buffer
	 * CyclicIterator.OfByte cyclicIterator = Iterators.c(circularBuffer);
	 * 
	 * // Simulate streaming data processing
	 * for (int i = 0; i < STREAM_SIZE; i++) {
	 *     // Read a byte of data from the stream
	 *     byte data = inputStream.readByte();
	 *     
	 *     // Add the data to the circular buffer
	 *     circularBuffer[cyclicIterator.getRevolutions()] = data;
	 *     
	 *     // Process the data from the circular buffer
	 *     processByteData(cyclicIterator.nextByte());
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * This practical usage demonstrates how {@code CyclicIterator.OfByte} can be
	 * used in streaming data processing scenarios to implement circular buffers,
	 * allowing efficient processing of continuous data streams.
	 * </p>
	 * 
	 * @implNote The use of {@link #nextByte()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextByte()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfByte extends PrimitiveIterator.OfByte, CyclicIterator<Byte> {
	}

	/**
	 * Interface for iterating over primitive {@code boolean} values in a cyclic
	 * manner. This interface is a purely primitive extension of
	 * {@code CyclicIterator} and extends {@code PrimitiveIterator.OfBoolean} to
	 * provide cyclic iteration capabilities specifically for {@code boolean}
	 * values.
	 * <p>
	 * <h4>Reason for existence:</h4> Cyclic iteration over primitive boolean values
	 * is commonly needed in scenarios such as simulating boolean flags in circular
	 * patterns or cycling through binary states.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * <code>
	 * boolean[] flags = {true, false, true};
	 * CyclicIterator.OfBoolean cyclicIterator = Iterators.c(flags);
	 * 
	 * while (cyclicIterator.getRevolutions() < 3) {
	 *     System.out.println(cyclicIterator.nextBoolean());
	 * }
	 * </code>
	 * </pre>
	 * 
	 * In this example, the cyclic iterator iterates over the boolean array three
	 * times, cycling through the values 'true', 'false', 'true' repeatedly.
	 * 
	 * @implNote The use of {@link #nextBoolean()} is preferred over the use of
	 *           {@link #next()} because {@link #next()} is implemented by calling
	 *           and casting {@link #nextBoolean()}.
	 * @implNote Default implementation does not support modification such as
	 *           {@link #remove()}
	 */
	interface OfBoolean extends PrimitiveIterator.OfBoolean, CyclicIterator<Boolean> {
	}

	/*
	 * Date created: 16 May 2024 Time created: 11:28:41
	 */
	/**
	 * Returns the number of complete revolutions made during iteration. A complete
	 * revolution is counted each time the iterator wraps around to the beginning of
	 * the collection.
	 * <p>
	 * If the number of complete revolutions is greater than or equal to
	 * {@link Integer#MAX_VALUE} then {@value Integer#MAX_VALUE} will be returned.
	 *
	 * @return the number of complete revolutions made during iteration
	 */
	int getRevolutions();

	/*
	 * Date created: 16 May 2024 Time created: 11:30:30
	 */
	/**
	 * Always returns {@code true} as there will always be movement in this
	 * {@code Iterator} seeing as it is a revolving one.
	 * 
	 * @return {@code true}
	 */
	@Override
	default boolean hasNext() {
		return true;
	}
}