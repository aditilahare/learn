# Use an official Python runtime as a parent image
FROM node:9.8.0


# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app
ADD . /package.json

# Install any needed packages specified in requirements.txt
RUN npm install

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME World
ENV PORT 8000

# Run app.js when the container launches
CMD ["node", "app/app.js"]
